package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.entity.Page;
import com.fiee.fieeblog.service.PageService;
import com.fiee.fieeblog.utils.OssUtils;
import com.fiee.fieeblog.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.fiee.fieeblog.enums.FilePathEnum.CONFIG;
import static com.fiee.fieeblog.enums.FilePathEnum.PAGES;

/**
 * @Author: Fiee
 * @ClassName: PageController
 * @Date: 2023/4/6
 * @Version: v1.0.0
 **/
@RestController
@RequestMapping("admin/")
@Api(tags = "页面管理")
public class PageController {
    @Autowired
    private PageService pageService;
    @Value("${upload.oss.endpoint}")
    public String endpoint;
    @Value("${upload.oss.accessKeySecret}")
    public String accessKeySecret;
    @Value("${upload.oss.accessKeyId}")
    public String accessKeyId;
    @Value("${upload.oss.bucketName}")
    public String bucketName;

    @ApiOperation("获取页面列表")
    @GetMapping("pages")
    public Result getPage(){
        return Result.ok(pageService.list());
    }

    @ApiOperation("更新或者保存页面")
    @PostMapping("pages")
    public Result saveOrUpdatePage(@RequestBody Page page){
        return Result.ok(pageService.saveOrUpdate(page));
    }

    @ApiOperation("删除页面")
    @DeleteMapping("pages/{id}")
    public Result delPage(@PathVariable Integer id){
        return Result.ok(pageService.removeById(id));
    }

    @ApiOperation("获取pageOssToken")
    @GetMapping("pages/getOssToken")
    public Result getOssToken() throws UnsupportedEncodingException {
        OssUtils ossUtils = new OssUtils();
        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName,PAGES.getPath());
        return Result.ok(ossToken);
    }
}
