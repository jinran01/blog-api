package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.service.ArticleService;
import com.fiee.fieeblog.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fiee
 * @ClassName: ArticleController
 * @Date: 2023/4/11
 * @Version: v1.0.0
 **/
@Api(tags = "文章管理")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("查看首页文章")
    @GetMapping("/articles")
    public Result getHomeArticles(){
        return Result.ok(articleService.getHomeArticles());
    }
}
