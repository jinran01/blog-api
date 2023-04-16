package com.fiee.fieeblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_menu】的数据库操作Mapper
* @createDate 2023-02-24 15:02:22
* @Entity .com.fiee.spring_security_auth.entity.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
//    List<Menu> getMenuList();
}




