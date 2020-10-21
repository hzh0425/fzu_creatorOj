package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthUser;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthUserMapper extends SuperMapper<AuthUser> {
    /**
     * 根据user email获取当前用户的角色以及权限
     */

    @Select("SELECT * FROM auth_user WHERE email=#{username}")
    @Results(value = {
            @Result(column = "uid",property = "uid",id = true),
            @Result(column = "uid",property = "roleList",many = @Many(select = "com.moxi.xo.mapper.AuthGroupMapper.getRolesByUserId")),
            @Result(column = "uid",property = "permissionList",many = @Many(select = "com.moxi.xo.mapper.AuthPermissionMapper.getPermissionsByOwnerId"))
    })
    public AuthUser loadUserByEmail(@Param("username") String username);
    /**
     * 根据user phone 获取当前用户的角色以及权限
     */
}
