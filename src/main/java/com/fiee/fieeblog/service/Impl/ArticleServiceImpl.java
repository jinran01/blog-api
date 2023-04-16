package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.dto.ArticleHomeDTO;
import com.fiee.fieeblog.entity.Article;
import com.fiee.fieeblog.service.ArticleService;
import com.fiee.fieeblog.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_article】的数据库操作Service实现
* @createDate 2023-04-11 16:48:23
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

    /**
     * 首页文章
     * @return
     */
    @Override
    public List<ArticleHomeDTO> getHomeArticles() {
        return baseMapper.homeArticleList();
    }
}




