package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.GapBank;
import com.moxi.xo.vo.GapFillBankVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface GapBankService extends SuperService<GapBank> {

   public  IPage<GapBank> getList(GapFillBankVo vo);

    public String addBatch(GapFillBankVo vo);

    public String edit(GapFillBankVo.GapFillVo vo, String userId);

    public String delete(String userId, String gid);

    public GapBank getById(String pid, String userId);
}
