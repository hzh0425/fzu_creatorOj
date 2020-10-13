package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.vo.ProgramBankVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ProgramBankService extends SuperService<ProgramBank> {

    public IPage<ProgramBank> getList(ProgramBankVo vo);

    public String addBatch(ProgramBankVo vo);

    public String delete(String pid);

    public String edit(ProgramBankVo.ProgramVo vo);
}
