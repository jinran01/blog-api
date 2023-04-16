package com.fiee.fieeblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.entity.Role;
import com.fiee.fieeblog.entity.RoleResource;

import java.util.List;


/**
* @author Fiee
* @description 针对表【tb_role_resource】的数据库操作Service
* @createDate 2023-02-24 15:13:48
*/
public interface RoleResourceService extends IService<RoleResource> {

    List getRoleResource(Role role);

}
