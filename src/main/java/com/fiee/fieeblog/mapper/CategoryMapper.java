package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Fiee
* @description 针对表【tb_category】的数据库操作Mapper
* @createDate 2023-05-14 19:11:41
* @Entity com.fiee.fieeblog.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




