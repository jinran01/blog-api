package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.dto.ArticleHomeDTO;
import com.fiee.fieeblog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_article】的数据库操作Mapper
* @createDate 2023-04-11 16:48:23
* @Entity com.fiee.fieeblog.entity.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<ArticleHomeDTO> homeArticleList();
}




