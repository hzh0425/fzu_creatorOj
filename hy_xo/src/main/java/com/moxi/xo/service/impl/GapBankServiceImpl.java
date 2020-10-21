package com.moxi.xo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moxi.base.enums.EPublicBank;
import com.moxi.base.enums.EShareMode;
import com.moxi.base.enums.EStatus;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.GapAnswer;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.GapBankMapper;
import com.moxi.xo.entity.GapBank;
import com.moxi.xo.service.GapBankService;
import com.moxi.xo.vo.GapFillBankVo;
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
public class GapBankServiceImpl extends SuperServiceImpl<GapBankMapper, GapBank> implements GapBankService {

    @Autowired
    GapBankService gapBankService;
    @Override
    public IPage<GapBank> getList(GapFillBankVo vo) {
        QueryWrapper<GapBank> wrapper;
        if(vo.getIsPublic()== EPublicBank.SELF_BANk){
            //如果请求的是私有题库
            wrapper=new QueryWrapper<GapBank>(){{
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
            //公共题库
            wrapper=new QueryWrapper<GapBank>(){{
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
        if(StringUtils.isNotEmpty(vo.getKeyword())){
            wrapper.like(SqlConf.NAME,vo.getKeyword());
        }
        wrapper.orderByDesc(SqlConf.CREATE_DATE);
        Page<GapBank> page=new Page<>(vo.getCurrentPage(),vo.getPageSize());
        IPage<GapBank> list=gapBankService.page(page,wrapper);
        list.getRecords().forEach(x->{
            if(x.getGapAnswerList()!=null){
                x.setGapAnswerList(JSON.parseArray(x.getQuestionAnswer(), GapAnswer.class));
            }
        });
        return list;
    }

    @Override
    public String addBatch(GapFillBankVo vo) {
        List<GapBank> gapBankList=vo.getGapFillVoList().stream().map(x->{
            String answerList=null;
            if(x.getGapAnswerList()!=null&&x.getGapAnswerList().size()>0){
                answerList= JSON.toJSONString(x.getGapAnswerList());
            }
            return new GapBank(x.getName(),x.getQuestionTitle(),x.getQuestionInfo(),answerList,x.getPublisher(),x.getPublisherId(),x.getShareMode(),new Date(),new Date());
        }).collect(Collectors.toList());
        gapBankService.saveBatch(gapBankList);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String edit(GapFillBankVo.GapFillVo vo, String userId) {
        GapBank pre=gapBankService.getById(vo.getUid());
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        //1.验证共享模式
        boolean flag=false;
        //验证权限
        if(pre.getPublisherId().equals(userId)){
            //如果创建该题目的用户
            flag=true;
        }else if(pre.getShareMode()== EShareMode.SHARE_READ_AND_WRITE){
            //如果用户设置为可读写模式
            flag=true;
        }else flag=false;

        if(flag){
            String GapAnswers=null;
            if(vo.getGapAnswerList()!=null&&vo.getGapAnswerList().size()>0){
                GapAnswers=JSON.toJSONString(vo.getGapAnswerList());
            }else{
                GapAnswers=pre.getQuestionAnswer();
            }
            pre.UpdateGapBank(vo.getName(),vo.getQuestionTitle(),vo.getQuestionInfo(),GapAnswers,vo.getShareMode());
            pre.updateById();
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
        }else{
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.INVALID_AUTH);
        }
    }

    @Override
    public String delete(String userId, String gid) {
        GapBank pre=gapBankService.getById(gid);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        if(pre.getPublisherId().equals(userId)){
            pre.deleteById();
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
        }
    }
}
