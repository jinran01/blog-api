package com.fiee.fieeblog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.entity.Role;
import com.fiee.fieeblog.entity.RoleMenu;

import java.util.List;


/**
* @author Fiee
* @description 针对表【tb_role_menu】的数据库操作Service
* @createDate 2023-02-24 15:12:19
*/
public interface RoleMenuService extends IService<RoleMenu> {

    List getRoleMenus(Integer id);

}
