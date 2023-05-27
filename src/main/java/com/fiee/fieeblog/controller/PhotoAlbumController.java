package com.fiee.fieeblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.entity.PhotoAlbum;
import com.fiee.fieeblog.service.PhotoAlbumService;
import com.fiee.fieeblog.utils.OssUtils;
import com.fiee.fieeblog.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.fiee.fieeblog.constant.OptTypeConst.REMOVE;
import static com.fiee.fieeblog.constant.OptTypeConst.SAVE_OR_UPDATE;
import static com.fiee.fieeblog.enums.FilePathEnum.ALBUM;
import static com.fiee.fieeblog.enums.FilePathEnum.PAGES;

/**
 * @Author: Fiee
 * @ClassName: PhotoAlbum
 * @Date: 2023/5/9
 * @Version: v1.0.0
 **/
@Api(tags = "照册管理")
@RestController
@RequestMapping("/admin")
public class PhotoAlbumController {
    @Autowired
    private PhotoAlbumService photoAlbumService;

    @Value("${upload.oss.endpoint}")
    public String endpoint;
    @Value("${upload.oss.accessKeySecret}")
    public String accessKeySecret;
    @Value("${upload.oss.accessKeyId}")
    public String accessKeyId;
    @Value("${upload.oss.bucketName}")
    public String bucketName;

    @ApiOperation(value = "查看后台相册")
    @GetMapping("/photos/albums")
    public Result getPhotoAlbums(@RequestParam String keywords){
//        System.out.println(keywords);
        return Result.ok(photoAlbumService.getPhotoAlbums(keywords));
    }

    @ApiOperation(value = "删除相册")
    @OptLog(optType = REMOVE)
    @DeleteMapping("/photos/albums/{id}")
    public Result deletePhotoAlbums(@PathVariable Integer id){
        return Result.ok(photoAlbumService.removeById(id));
    }

    @ApiOperation(value = "获取相册信息")
    @GetMapping("/photos/album/{id}/info")
    public Result getPhotoAlbumById(@PathVariable Integer id){
        System.out.println(id);
        return Result.ok(photoAlbumService.getById(id));
    }

    @ApiOperation(value = "保存或更新相册")
    @OptLog(optType = SAVE_OR_UPDATE)
    @PostMapping("/photos/albums")
    public Result getPhotoAlbum(@RequestBody PhotoAlbum photoAlbum){
        photoAlbumService.saveOrUpdate(photoAlbum);
        return Result.ok(photoAlbum.getId());
    }

    @ApiOperation("获取相册OssToken")
    @GetMapping("/photos/albums/cover")
    public Result getOssToken() throws UnsupportedEncodingException {
        OssUtils ossUtils = new OssUtils();
        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName,ALBUM.getPath());
        return Result.ok(ossToken);
    }
}
