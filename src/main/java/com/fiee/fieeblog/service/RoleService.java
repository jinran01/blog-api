package com.fiee.fieeblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.dto.ResourceRoleDTO;
import com.fiee.fieeblog.dto.RoleDTO;
import com.fiee.fieeblog.entity.Role;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
* @author Fiee
* @description 针对表【tb_role】的数据库操作Service
* @createDate 2023-02-24 15:08:27
*/
public interface RoleService extends IService<Role> {
    List<String> listRolesByUserInfoId(Integer userInfoId);

    List<ResourceRoleDTO> listResourceRoles();

    /**
     * 查询角色
     * @param conditionVO
     * @return
     */
    PageResult<RoleDTO> listRoles(ConditionVO conditionVO);
    /**
     * 删除角色
     * @param roleIds
     * @return
     */
    boolean delRoles(List<Integer> roleIds);
    /**
     * 角色禁用
     * @param role
     * @return
     */
    boolean removeRoles(Role role);

    /**
     * 添加角色
     * @param map
     * @return
     */
    boolean addRole(Map map);

    /**
     * 更新角色菜单
     * @param map
     * @return
     */
    boolean updateMenus(Map map);

    /**
     * 更新角色资源
     * @param map
     * @return
     */
    boolean updateResources(Map map);
}
