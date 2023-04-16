package com.fiee.fieeblog.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Role;
import com.fiee.fieeblog.entity.RoleMenu;
import com.fiee.fieeblog.entity.RoleResource;
import com.fiee.fieeblog.mapper.RoleResourceMapper;
import com.fiee.fieeblog.service.RoleResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_role_resource】的数据库操作Service实现
* @createDate 2023-02-24 15:13:48
*/
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource>
    implements RoleResourceService {


    @Override
    public List getRoleResource(Role role) {
        LambdaQueryWrapper<RoleResource> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoleResource::getRoleId,role.getId());
        return baseMapper.selectList(wrapper);
    }

}




