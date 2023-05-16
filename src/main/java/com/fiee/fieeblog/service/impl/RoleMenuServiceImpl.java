package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.RoleMenu;
import com.fiee.fieeblog.mapper.RoleMenuMapper;
import com.fiee.fieeblog.service.RoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_role_menu】的数据库操作Service实现
* @createDate 2023-02-24 15:12:19
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService {

    @Override
    public List<RoleMenu> getRoleMenus(Integer id) {
        LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoleMenu::getRoleId,id);
        return baseMapper.selectList(wrapper);
    }

}




