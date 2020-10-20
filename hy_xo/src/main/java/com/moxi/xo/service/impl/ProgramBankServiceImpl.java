package com.moxi.xo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        QueryWrapper<ProgramBank> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getKeyword())){
            wrapper.like(SqlConf.QUESTION_TITLE,vo.getKeyword());
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
        List<ProgramBank> list=vo.getProgramVoList().stream().map(x->{
            String programExamples=null;
            if(x.getExampleVoList()!=null&&x.getExampleVoList().size()>0){
                programExamples= JSON.toJSONString(x.getExampleVoList());
            }
            return new ProgramBank(x.getQuestionTitle(),x.getQuestionContent(),programExamples,x.getUpperTime(),x.getUpperMemory(),x.getPublisher(),x.getPublisherId(),x.getShareMode(),new Date(),new Date());
        }).collect(Collectors.toList());
        //保存
        programBankService.saveBatch(list);
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.INSERT_SUCCESS);
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
    public String edit(ProgramBankVo.ProgramVo vo) {
        ProgramBank program=programBankService.getById(vo.getUid());
        if(program==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        String examples=null;
        if(vo.getExampleVoList()!=null&&vo.getExampleVoList().size()!=0){
            examples=JSON.toJSONString(vo.getExampleVoList());
        }else{
            examples=program.getQuestionExample();
        }
        program.UpdateProgramBank(vo.getQuestionTitle(),vo.getQuestionContent(),examples,vo.getUpperTime(),vo.getUpperMemory(),vo.getShareMode());
        program.updateById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
    }
}
