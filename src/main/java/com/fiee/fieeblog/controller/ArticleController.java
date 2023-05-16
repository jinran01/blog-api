package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.entity.Article;
import com.fiee.fieeblog.service.ArticleService;
import com.fiee.fieeblog.utils.OssUtils;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.ArticleVO;
import com.fiee.fieeblog.vo.ConditionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.fiee.fieeblog.enums.FilePathEnum.ALBUM;
import static com.fiee.fieeblog.enums.FilePathEnum.ARTICLE_COVER;

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

    @Value("${upload.oss.endpoint}")
    public String endpoint;
    @Value("${upload.oss.accessKeySecret}")
    public String accessKeySecret;
    @Value("${upload.oss.accessKeyId}")
    public String accessKeyId;
    @Value("${upload.oss.bucketName}")
    public String bucketName;

    @ApiOperation("查看首页文章")
    @GetMapping("/articles")
    public Result getHomeArticles(){
        return Result.ok(articleService.getHomeArticles());
    }

    @ApiOperation("添加获取修改文章")
    @PostMapping("/admin/articles")
    public Result saveArticle(@RequestBody ArticleVO articleVO){
        return Result.ok(articleService.saveOrUpdateArticle(articleVO));
    }

    @ApiOperation("查看后台文章")
    @GetMapping("/admin/articles")
    public Result getArticleById(ConditionVO vo){
        return Result.ok(articleService.getBackArticle(vo));
    }
    @ApiOperation("根据id查看后台文章")
    @GetMapping("/admin/articles/{id}")
    public Result getArticleById(@PathVariable Integer id){
        return Result.ok(articleService.getArticleById(id));
    }
    @ApiOperation("上传文章封面OssToken")
    @GetMapping("/admin/articles/cover")
    public Result getOssToken() throws UnsupportedEncodingException {
        OssUtils ossUtils = new OssUtils();
        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName,ARTICLE_COVER.getPath());
        return Result.ok(ossToken);
    }
//    @ApiOperation("修改文章")
//    @PutMapping("/admin/articles")
//    public Result UpdateArticle(@RequestBody Article article){
//        return Result.ok(articleService.getHomeArticles());
//    }
}
