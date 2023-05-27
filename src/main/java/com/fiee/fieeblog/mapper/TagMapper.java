package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_tag】的数据库操作Mapper
* @createDate 2023-04-09 21:11:19
* @Entity com.fiee.fieeblog.entity.Tag
*/
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    List<String> listTagNameByArticleId(Integer articleId);

    List<Tag> getTagList(@Param("vo") ConditionVO vo,Long current,Long size);
}




