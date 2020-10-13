package com.moxi.xo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moxi.base.enums.EOption;
import com.moxi.base.enums.EStatus;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.OptionSelect;
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
        if(StringUtils.isNotEmpty(vo.getKeyword())){
            wrapper.like(SqlConf.QUESTION_TITLE,vo.getKeyword());
        }
        if(vo.getOptionType()>0){
            wrapper.eq(SqlConf.OPTION_TYPE,vo.getOptionType());
        }
        wrapper.orderByDesc(SqlConf.CREATE_DATE);
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
                    if(vo.getOptionType()!=EOption.JUDGE_CHOICE&&vo.getOptionVoList()!=null&&vo.getOptionVoList().size()>0){
                        selectLists= JSON.toJSONString(vo.getOptionVoList());
                    }
                    return new OptionBank(x.getQuestionTitle(),selectLists,x.getOptionType(),x.getQuestionAnswer(),x.getPublisher(), EStatus.ENABLE,new Date(),new Date());
                }).collect(Collectors.toList());
        optionBankService.saveBatch(optionList);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String edit(OptionBankVo.OptionVo vo) {
        OptionBank pre=optionBankService.getById(vo.getUid());
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        String questionSelects=null;
        if(vo.getOptionSelectList()!=null&&vo.getOptionSelectList().size()>0){
            questionSelects=JSON.toJSONString(vo.getOptionSelectList());
        }else{
            questionSelects=pre.getQuestionSelect();
        }
        pre.UpdateOptionBank(vo.getQuestionTitle(),questionSelects, StringUtils.isNotBlank(vo.getQuestionAnswer()) ?vo.getQuestionAnswer():pre.getQuestionAnswer(),vo.getOptionType());
        pre.updateById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String delete(String oid) {
        OptionBank pre=optionBankService.getById(oid);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.deleteById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
    }
}
