package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthPermission;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthPermissionMapper extends SuperMapper<AuthPermission> {
    /**
     * 根据roleId获取该用户所有权限
     */
    @Select("SELECT a2.* FROM auth_role_permission a1 \n" +
            "JOIN auth_permission a2\n" +
            "ON a1.pid=a2.uid \n" +
            "WHERE a1.rid=#{roleId}")
    public List<AuthPermission> getPermissionsByRoleId(String roleId);
}
