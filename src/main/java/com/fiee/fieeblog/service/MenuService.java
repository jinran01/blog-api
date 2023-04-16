package com.fiee.fieeblog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.entity.Menu;

import java.util.List;


/**
* @author Fiee
* @description 针对表【tb_menu】的数据库操作Service
* @createDate 2023-02-24 15:00:49
*/
public interface MenuService extends IService<Menu> {

    List<Menu> getMenuList(String menuName);

    boolean delMenu(Integer id);

    boolean updateMenu(Menu menu);
}
