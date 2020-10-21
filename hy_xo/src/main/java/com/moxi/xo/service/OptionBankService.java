package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.OptionBank;
import com.moxi.xo.vo.OptionBankVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface OptionBankService extends SuperService<OptionBank> {

    public IPage<OptionBank> getList(OptionBankVo vo);

    public String addBatch(OptionBankVo vo);

    public String edit(OptionBankVo.OptionVo vo, String userId);

    public String delete(String userId, String oid);
}
