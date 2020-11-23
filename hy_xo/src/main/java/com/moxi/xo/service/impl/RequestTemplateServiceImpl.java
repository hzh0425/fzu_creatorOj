package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.moxi.codeBase.Interface.SuperServiceImpl;
import com.moxi.xo.entity.RequestTemplate;
import com.moxi.xo.mapper.RequestTemplateMapper;
import com.moxi.xo.service.RequestTemplateService;
import org.springframework.stereotype.Service;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/20 21:17
 */
@Service
public class RequestTemplateServiceImpl extends SuperServiceImpl<RequestTemplateMapper, RequestTemplate> implements RequestTemplateService {
}
