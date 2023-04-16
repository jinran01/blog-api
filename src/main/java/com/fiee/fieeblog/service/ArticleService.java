package com.fiee.fieeblog.service;

import com.fiee.fieeblog.dto.ArticleHomeDTO;
import com.fiee.fieeblog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_article】的数据库操作Service
* @createDate 2023-04-11 16:48:23
*/
public interface ArticleService extends IService<Article> {

    List<ArticleHomeDTO> getHomeArticles();
}
