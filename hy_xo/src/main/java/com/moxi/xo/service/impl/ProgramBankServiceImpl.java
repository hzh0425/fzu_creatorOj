package com.moxi.xo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moxi.base.entity.SuperEntity;
import com.moxi.base.enums.EPublicBank;
import com.moxi.base.enums.EShareMode;
import com.moxi.base.enums.EStatus;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.entity.ProgramExample;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.ProgramBankMapper;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.vo.ProgramBankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class ProgramBankServiceImpl extends SuperServiceImpl<ProgramBankMapper, ProgramBank> implements ProgramBankService {


    @Autowired
    ProgramBankService programBankService;
    @Override
    public IPage<ProgramBank> getList(ProgramBankVo vo) {
        QueryWrapper<ProgramBank> wrapper;
        if(vo.getIsPublic()== EPublicBank.SELF_BANk){
            //若申请的是私人的题目集
            wrapper=new QueryWrapper<ProgramBank>(){{
                //搜索关键字
                if(StringUtils.isNotEmpty(vo.getKeyword())){
                    like(SqlConf.QUESTION_TITLE,vo.getKeyword());
                }
                //PublisherId
                eq(SqlConf.PUBLISHER_ID,vo.getPublisherId());
                //降序排序
                orderByDesc(SqlConf.CREATE_DATE);
            }};
        }else{
            //公共题目集
            wrapper=new QueryWrapper<ProgramBank>(){{
                //搜索关键字
                if(StringUtils.isNotEmpty(vo.getKeyword())){
                    like(SqlConf.QUESTION_TITLE,vo.getKeyword());
                }
                //shareMode
                ge(SqlConf.SHARE_MODE,EShareMode.SHARE_ONLY_READ);
                //降序排序
                orderByDesc(SqlConf.CREATE_DATE);
            }};
        }
        Page<ProgramBank> page=new Page(vo.getCurrentPage(),vo.getPageSize());
        IPage<ProgramBank>  list=programBankService.page(page,wrapper);
        list.getRecords().forEach(x->{
            if(StringUtils.isNotEmpty(x.getQuestionExample())){
                x.setExampleList(JSON.parseArray(x.getQuestionExample(), ProgramExample.class));
            }
        });
        return list;
    }

    @Override
    public String addBatch(ProgramBankVo vo) {
        //1.构造programBank list
        List<ProgramBank> programBanks=vo.getProgramVoList().stream().map(x->{
            String programExamples=null;
            if(x.getExampleVoList()!=null&&x.getExampleVoList().size()>0){
                programExamples= JSON.toJSONString(x.getExampleVoList());
            }
            return new ProgramBank(x.getQuestionTitle(),x.getQuestionContent(),programExamples,x.getUpperTime(),x.getUpperMemory(),x.getPublisher(),x.getPublisherId(),x.getShareMode(),new Date(),new Date());
        }).collect(Collectors.toList());
        //保存
        programBankService.saveBatch(programBanks);
        //返回uid
        List<String> uids=programBanks.stream().map(SuperEntity::getUid).collect(Collectors.toList());
        return ResultUtil.result(SysConf.SUCCESS,uids);
    }


    @Override
    public String delete(String programId, String userId) {
        ProgramBank pre=programBankService.getById(programId);
        if(pre==null)return ResultUtil.result(SysConf.ERROR, MessageConf.ENTITY_NOT_EXIST);
        if(pre.getPublisherId().equals(userId)){
            pre.deleteById();
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
        }
    }

    @Override
    public String edit(ProgramBankVo.ProgramVo vo, String userId) {
        ProgramBank program=programBankService.getById(vo.getUid());
        if(program==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        boolean flag=false;
        //验证权限
        if(program.getPublisherId().equals(userId)){
            //如果创建该题目的用户
            flag=true;
        }else if(program.getShareMode()== EShareMode.SHARE_READ_AND_WRITE){
            //如果用户设置为可读写模式
            flag=true;
        }else flag=false;

        if(flag){
            String examples=null;
            if(vo.getExampleVoList()!=null&&vo.getExampleVoList().size()!=0){
                examples=JSON.toJSONString(vo.getExampleVoList());
            }else{
                examples=program.getQuestionExample();
            }
            program.UpdateProgramBank(vo.getQuestionTitle(),vo.getQuestionContent(),examples,vo.getUpperTime(),vo.getUpperMemory(),vo.getShareMode());
            program.updateById();
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
        }
    }

    @Override
    public ProgramBank getById(String pid, String userId) {
        ProgramBank program=programBankService.getById(pid);
        if(program!=null&&StringUtils.isNotEmpty(program.getQuestionExample())){
            program.setExampleList(JSON.parseArray(program.getQuestionExample(), ProgramExample.class));
        }
        return program;
    }
}
