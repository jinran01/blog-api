package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Fiee
* @description 针对表【tb_tag】的数据库操作Mapper
* @createDate 2023-04-09 21:11:19
* @Entity com.fiee.fieeblog.entity.Tag
*/
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}




