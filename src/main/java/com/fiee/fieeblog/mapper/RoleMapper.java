package com.fiee.fieeblog.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.dto.ResourceRoleDTO;
import com.fiee.fieeblog.dto.RoleDTO;
import com.fiee.fieeblog.entity.Role;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_role】的数据库操作Mapper
* @createDate 2023-02-24 15:08:27
* @Entity .com.fiee.spring_security_auth.entity.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<String> listRolesByUserInfoId(Integer userInfoId);

    /**
     * 查询路由角色列表
     *
     * @return 角色标签
     */
    List<ResourceRoleDTO> listResourceRoles();


    /**
     * 查询角色列表
     *
     * @param current     页码
     * @param size        条数
     * @param conditionVO 条件
     * @return 角色列表
     */
    List<RoleDTO> listRoles(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

}




