package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.dto.BlogInfoDTO;
import com.fiee.fieeblog.service.WebsiteConfigService;
import com.fiee.fieeblog.utils.OssUtils;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.WebsiteConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.fiee.fieeblog.enums.FilePathEnum.CONFIG;

/**
 * @Author: Fiee
 * @ClassName: BlogInfoController
 * @Date: 2023/4/1
 * @Version: v1.0.0
 **/

@RestController
@Api(tags = "博客信息模块")
public class BlogInfoController {
    @Autowired
    private WebsiteConfigService websiteConfigService;
    @Value("${upload.oss.endpoint}")
    public String endpoint;
    @Value("${upload.oss.accessKeySecret}")
    public String accessKeySecret;
    @Value("${upload.oss.accessKeyId}")
    public String accessKeyId;
    @Value("${upload.oss.bucketName}")
    public String bucketName;

    @ApiOperation(value = "查看博客信息")
    @GetMapping("/")
    public Result<BlogInfoDTO> getBlogInfo(){
        return Result.ok(websiteConfigService.getBlogInfo());
    }

    @ApiOperation(value = "查看博客配置信息")
    @GetMapping("/admin/website/config")
    public Result<WebsiteConfigVO> getWebsiteConfig(){
        WebsiteConfigVO websiteConfig = websiteConfigService.getWebsiteConfig();
        return Result.ok(websiteConfig);
    }

    @ApiOperation(value = "保存网站配置信息")
    @PostMapping("/admin/website/config")
    public Result saveWebsiteConfig(@RequestBody WebsiteConfigVO vo){
        websiteConfigService.saveWebsiteConfig(vo);
        return Result.ok();
    }

    @ApiOperation("获取ConfigOssToken")
    @GetMapping("/admin/getConfigOssToken")
    public Result getOssToken() throws UnsupportedEncodingException {
        OssUtils ossUtils = new OssUtils();
        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName,CONFIG.getPath());
        return Result.ok(ossToken);
    }
}
