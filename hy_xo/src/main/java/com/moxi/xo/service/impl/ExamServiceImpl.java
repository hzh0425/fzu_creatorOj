package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.moxi.codeBase.Interface.SuperServiceImpl;
import com.moxi.codeBase.enums.EProblemType;
import com.moxi.codeBase.enums.EResourceType;
import com.moxi.codeBase.utils.ResultUtil;
import com.moxi.xo.entity.Class;
import com.moxi.xo.entity.ExamBank;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.ExamMapper;
import com.moxi.xo.mapper.GapBankMapper;
import com.moxi.xo.mapper.OptionBankMapper;
import com.moxi.xo.mapper.ProgramBankMapper;
import com.moxi.xo.service.AuthPermissionService;
import com.moxi.xo.service.ExamBankService;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.entity.Exam;
import com.moxi.xo.util.ResourceUtil;
import com.moxi.xo.vo.BankListVo;
import com.moxi.xo.vo.ExamVo;
import com.moxi.xo.vo.ResourceReturningVo;
import com.moxi.xo.vo.StuExamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Service
public class ExamServiceImpl extends SuperServiceImpl<ExamMapper, Exam> implements ExamService {

    @Autowired
    ExamService examService;
    @Autowired
    ExamMapper examMapper;
    @Autowired
    ExamBankService examBankService;
    @Resource
    OptionBankMapper optionBankMapper;
    @Resource
    GapBankMapper gapBankMapper;
    @Resource
    ProgramBankMapper programBankMapper;
    @Autowired
    ResourceUtil resourceUtil;
    @Autowired
    AuthPermissionService authPermissionService;
    @Override
    public IPage<Exam> getList(String classId, ExamVo vo) {
        QueryWrapper<Exam> wrapper=new QueryWrapper<Exam>(){{
            //如果关键字不为空
            if(StringUtils.isNotEmpty(vo.getKeyword())){
                like(SqlConf.EXAM_NAME,vo.getKeyword());
            }
            //classId
            eq(SqlConf.CLASS_ID,classId);
            orderByDesc(SqlConf.CREATE_DATE);
        }};
        Page<Exam> page=new Page<>(vo.getCurrentPage(),vo.getPageSize());
        return examService.page(page,wrapper);
    }

    @Override
    public IPage<Exam> getListForStu(StuExamVo vo) {

        QueryWrapper<Exam> wrapper= new QueryWrapper<Exam>(){{
            //中间表tid
            eq( SqlConf.SID,vo.getStuId() );
            //2.模糊查询
            if( StringUtils.isNotEmpty(vo.getKeyword()) ){
                like( SqlConf.EXAM_NAME,vo.getKeyword() );
            }
            //3.降序排序
            orderByDesc( SqlConf.CREATE_DATE );
        }};
        //2.构建page
        Page<Exam> page= new Page<>( vo.getCurrentPage(), vo.getPageSize() );
        return examMapper.getListByStuId( page,wrapper );
    }

    @Override
    public String add(String classId, ExamVo vo) {
        //0.先查询当前班级下的该考试是否存在
        QueryWrapper<Exam> wrapper=new QueryWrapper<Exam>(){{
            eq(SqlConf.EXAM_NAME,vo.getExamName());
            eq(SqlConf.CLASS_ID,classId);
        }};
        if(examService.count(wrapper)>0){
            return ResultUtil.result(SysConf.ERROR,MessageConf.EXAM_EXIST);
        }
        //1.创建考试,获取eid
        Exam exam=new Exam(classId,vo.getExamName(),vo.getStartTime(),vo.getEndTime(),vo.getPublisher());
        exam.insert();
        String eid=exam.getUid();
        //2.创建考试对应的题目集
        if(vo.getExamBankVoList()!=null){
            List<ExamBank> bankList=vo.getExamBankVoList().stream().parallel()
                    .map(x->{
                        return new ExamBank(eid,x.getBid(),x.getType(),x.getNum(),x.getScore());
                    }).collect(Collectors.toList());
            examBankService.saveBatch(bankList);
        }
        //3.资源增加返回体
        ResourceReturningVo templateVo=new ResourceReturningVo(vo.getTid(),SysConf.SUCCESS,exam.getUid(),SysConf.RESOURCE_EXAM);
        //4.增加考试的权限
        resourceUtil.buildPermissionAfterAddResource(templateVo, EResourceType.RESOURCE_EXAM);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String delete(String eid) {
        //1.删除考试
        Exam pre=examService.getById(eid);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.deleteById();
        //2.删除考试题目
        QueryWrapper<ExamBank> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.EID,eid);
        examBankService.remove(wrapper);
        //3.删除资源表的数据
        authPermissionService.deleteResource(eid);
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String edit(ExamVo vo) {
        Exam pre=examService.getById(vo.getUid());
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.UpdateExam(vo.getExamName(),vo.getStartTime(),vo.getEndTime());
        pre.updateById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public List getListAsType(BankListVo vo) {
        
        switch (vo.getProblemType()){
            case EProblemType.option:{
                //选择
                return optionBankMapper.getExamOptionList(vo.getExamId());
            }
            case EProblemType.gapFill:{
                //填空
                return gapBankMapper.getExamGapList(vo.getExamId());
            }
            case EProblemType.program:{
                //编程,编程先返回title,而不是返回具体的题目(因为数据太大)
                return programBankMapper.getExamProgramList(vo.getExamId());
            }
        }
        return null;
    }

    @Override
    public String addProblemBatch(BankListVo vo) {
        List<ExamBank> bankList=vo.getBankVoList().stream().map(x->{
            return new ExamBank(vo.getExamId(),x.getBid(),x.getType(),x.getNum(),x.getScore());
        }).collect(Collectors.toList());
        examBankService.saveBatch(bankList);
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String deleteProblem(String eid, String bid) {
        QueryWrapper<ExamBank> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.EID,eid);
        wrapper.eq(SqlConf.BID,bid);
        ExamBank pre=examBankService.getOne(wrapper);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.deleteById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
    }




    @Override
    public IPage getProblemList(String examId, int problemType) {
        return null;
    }

    @Override
    public IPage doGetProblemList(String examId, int... problemTypes) {
        return null;
    }
}
