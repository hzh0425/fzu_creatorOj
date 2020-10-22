package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthPermission;
import org.apache.ibatis.annotations.Param;
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
    @Select("SELECT a2.* FROM auth_group_permission a1 \n" +
            "JOIN auth_permission a2\n" +
            "ON a1.pid=a2.uid \n" +
            "WHERE a1.rid=#{roleId}")
    public List<AuthPermission> getPermissionsByRoleId(String roleId);
    /**
     * 根据ownerId获取用户所有权限
     */
    @Select("select * from auth_permission where owner_id=#{ownerId}")
    public List<AuthPermission> getPermissionsByOwnerId(String ownerId);

    /**
     * 获取该班级下的所有资源对应的resource_id
     */
    @Select("SELECT uid,resourceTypeId,resourceType,resourceDesc,operandDesc FROM auth_permission WHERE resource_id IN(\n" +
            "\tSELECT uid FROM auth_group WHERE class_id=#{classId} \n" +
            "\tUNION ALL\n" +
            "\tSELECT uid FROM exam WHERE class_id=#{classId} \n" +
            "\tUNION ALL\n" +
            "\tSELECT #{classId} \n" +
            ") ORDER BY resource_type_id ")
    public List<AuthPermission> getPermissionSelectTable(@Param("classId")String classId);

}
