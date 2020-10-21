package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthGroup;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/21 16:33
 */
public interface AuthGroupMapper extends SuperMapper<AuthGroup> {
    /**
     * 根据用户Id,获取该用户所有的role及其所对应的权限
     */
    @Select("SELECT a2.* FROM \n" +
            "auth_user_role a1 JOIN auth_role a2 \n" +
            "ON a1.rid=a2.uid \n" +
            "WHERE a1.usid=#{uid} ")
    @Results(value = {
            @Result(column = "uid",property = "permissionList" ,many = @Many(select = "com.moxi.xo.mapper.AuthPermissionMapper.getPermissionsByRoleId"))
    })
    List<AuthGroup> getRolesByUserId(String uid);
}
