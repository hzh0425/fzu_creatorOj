package com.moxi.xo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moxi.codeBase.Interface.SuperServiceImpl;
import com.moxi.codeBase.enums.EOption;
import com.moxi.codeBase.enums.EPublicBank;
import com.moxi.codeBase.enums.EShareMode;
import com.moxi.codeBase.utils.ResultUtil;
import com.moxi.codeBase.utils.StringUtils;
import com.moxi.xo.entity.OptionSelect;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.OptionBankMapper;
import com.moxi.xo.service.OptionBankService;
import com.moxi.xo.entity.OptionBank;
import com.moxi.xo.vo.OptionBankVo;
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
public class OptionBankServiceImpl extends SuperServiceImpl<OptionBankMapper, OptionBank> implements OptionBankService {

    @Autowired
    OptionBankService optionBankService;

    @Override
    public IPage<OptionBank> getList(OptionBankVo vo) {
        QueryWrapper<OptionBank>wrapper=new QueryWrapper();
        if(vo.getIsPublic()== EPublicBank.SELF_BANk){
            //若申请的是私人的题目集
            wrapper=new QueryWrapper<OptionBank>(){{
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
            wrapper=new QueryWrapper<OptionBank>(){{
                //搜索关键字
                if(StringUtils.isNotEmpty(vo.getKeyword())){
                    like(SqlConf.QUESTION_TITLE,vo.getKeyword());
                }
                //shareMode
                ge(SqlConf.SHARE_MODE, EShareMode.SHARE_ONLY_READ);
                //降序排序
                orderByDesc(SqlConf.CREATE_DATE);
            }};
        }
        Page<OptionBank> page=new Page<>(vo.getCurrentPage(),vo.getPageSize());
        IPage<OptionBank> list=optionBankService.page(page,wrapper);
        list.getRecords().forEach(x->{
            if(x.getQuestionSelect()!=null){
                x.setSelectList(JSON.parseArray(x.getQuestionSelect(),OptionSelect.class));
            }
        });
        return list;
    }

    @Override
    public String addBatch(OptionBankVo vo) {
        List<OptionBank> optionList=vo.getOptionVoList().stream()
                .map(x->{
                    String selectLists=null;
                    //如果不是多选题类型,需要构造选项
                    if(vo.getOptionType()!= EOption.JUDGE_CHOICE&&vo.getOptionVoList()!=null&&vo.getOptionVoList().size()>0){
                        selectLists= JSON.toJSONString(x.getOptionSelectList());
                    }
                    return new OptionBank(x.getQuestionTitle(),selectLists,x.getOptionType(),x.getQuestionAnswer(),x.getPublisher(),x.getPublisherId(),x.getShareMode(),new Date(),new Date());
                }).collect(Collectors.toList());
        optionBankService.saveBatch(optionList);
        //返回uids
        List<String>uids=optionList.stream().map(x->x.getUid()).collect(Collectors.toList());;
        return ResultUtil.result(SysConf.SUCCESS, uids);
    }

    @Override
    public String edit(OptionBankVo.OptionVo vo, String userId) {
        OptionBank pre=optionBankService.getById(vo.getUid());
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        boolean flag=false;
        //验证权限
        if(pre.getPublisherId().equals(userId)){
            //如果创建该题目的用户
            flag=true;
        }else if(pre.getShareMode()== EShareMode.SHARE_READ_AND_WRITE){
            //如果用户设置为可读写模式
            flag=true;
        }
        if(flag){
            String questionSelects=null;
            if(vo.getOptionSelectList()!=null&&vo.getOptionSelectList().size()>0){
                questionSelects=JSON.toJSONString(vo.getOptionSelectList());
            }else{
                questionSelects=pre.getQuestionSelect();
            }
            pre.UpdateOptionBank(vo.getQuestionTitle(),questionSelects, StringUtils.isNotBlank(vo.getQuestionAnswer()) ?vo.getQuestionAnswer():pre.getQuestionAnswer(),vo.getOptionType(),vo.getShareMode());
            pre.updateById();
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
        }
    }

    @Override
    public String delete(String userId, String oid) {
        OptionBank pre=optionBankService.getById(oid);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        if(pre.getPublisherId().equals(userId)){
            pre.deleteById();
            return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
        }
    }

    @Override
    public OptionBank getById(String pid, String userId) {
        OptionBank optionBank=optionBankService.getById(pid);
        if(optionBank!=null&&StringUtils.isNotEmpty(optionBank.getQuestionSelect())){
            optionBank.setSelectList(JSON.parseArray(optionBank.getQuestionSelect(),OptionSelect.class));
        }
        return optionBank;
    }
}
