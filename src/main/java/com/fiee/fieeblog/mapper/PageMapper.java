package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Fiee
* @description 针对表【tb_page(页面)】的数据库操作Mapper
* @createDate 2023-04-06 22:18:13
* @Entity com.fiee.fieeblog.entity.Page
*/
@Mapper
public interface PageMapper extends BaseMapper<Page> {

}




