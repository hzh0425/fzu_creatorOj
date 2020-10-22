package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.AuthGroup;
import com.moxi.xo.vo.PermissionGroupVo;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthGroupService extends SuperService<AuthGroup> {

    public IPage<AuthGroup> getList(PermissionGroupVo vo);

    public String add(PermissionGroupVo vo, String userId);

    public  String edit(PermissionGroupVo vo);

    public String delete(String groupId);

    public List getPermissionTable(PermissionGroupVo vo);
}
