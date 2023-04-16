package com.fiee.fieeblog.utils;

import com.fiee.fieeblog.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Fiee
 * @ClassName: doListHandler
 * @Date: 2023/3/2
 * @Version: v1.0.0
 **/
public class MenuHelper {
    public static List buildTree(List<Menu> list){
        List<Menu> tree = new ArrayList<>();
        for (Menu item : list) {
            if (item.getParentId() == 0){
                tree.add(doHelper(item,list));
            }
        }
        return tree;
    }

    public static Menu doHelper(Menu menu, List<Menu> menuList){
        menu.setChildren(new ArrayList<>());
        for (Menu item : menuList) {
            //获取菜单id
            Integer cid = menu.getId();
            //获取所有菜单(item)的parentId
            Integer parentId = item.getParentId();
            //两个Integer对象 直接new Integer 创建的两个对象之间比较比地址为false
            if (cid.equals(parentId)){
                if (menu.getChildren() == null){
                    menu.setChildren(new ArrayList<>());
                }
                menu.getChildren().add(doHelper(item,menuList));
            }
        }
        return menu;
    }
}
