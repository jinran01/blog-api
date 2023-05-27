package com.fiee.fieeblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fiee.fieeblog.entity.Photo;
import com.fiee.fieeblog.service.PhotoService;
import com.fiee.fieeblog.utils.OssUtils;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.fiee.fieeblog.enums.FilePathEnum.ALBUM;
import static com.fiee.fieeblog.enums.FilePathEnum.PHOTO;

/**
 * @Author: Fiee
 * @ClassName: PhotoController
 * @Date: 2023/5/9
 * @Version: v1.0.0
 **/
@Api(tags = "照片管理")
@RestController
@RequestMapping("/admin")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Value("${upload.oss.endpoint}")
    public String endpoint;
    @Value("${upload.oss.accessKeySecret}")
    public String accessKeySecret;
    @Value("${upload.oss.accessKeyId}")
    public String accessKeyId;
    @Value("${upload.oss.bucketName}")
    public String bucketName;

    @ApiOperation(value = "保存照片")
    @PostMapping("/photos")
    public Result savePhoto(@RequestBody Photo[] photos){
        photoService.saveOrUpdateBatch(Arrays.asList(photos));
        return Result.ok();
    }

    @ApiOperation(value = "获取照片列表")
    @GetMapping("/photos")
    public Result<PageResult> getPhotoList(ConditionVO conditionVO){
        return Result.ok(photoService.getPhotoList(conditionVO));
    }

//    @ApiOperation(value = "通过相册Id获取相片")
//    @GetMapping("/photos/{albumId}")
//    public Result getPhotos(@PathVariable Integer albumId){
//        LambdaQueryWrapper<Photo> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Photo::getAlbumId,albumId);
//        List<Photo> list = photoService.list(wrapper);
//        return Result.ok(list);
//    }

    @ApiOperation(value = "逻辑删除相片")
    @DeleteMapping ("/photos/remove")
    public Result removePhotos(@RequestBody Photo[] photos){
        return Result.ok(photoService.updateBatchById(Arrays.asList(photos)));
    }

    @ApiOperation(value = "物理删除相片")
    @DeleteMapping("/photos/delete")
    public Result delPhotos(@RequestBody Integer[] ids){
        return Result.ok(photoService.removeBatchByIds(Arrays.asList(ids)));
    }

    @ApiOperation(value = "恢复相片")
    @PutMapping("/photos")
    public Result recyclePhotos(@RequestBody Photo[] photos){
//        System.out.println(photos);
        photoService.updateBatchById(Arrays.asList(photos));
        return Result.ok();
    }

    @ApiOperation("获取相片OssToken")
    @GetMapping("/photos/oss")
    public Result getOssToken() throws UnsupportedEncodingException {
        OssUtils ossUtils = new OssUtils();
        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName,PHOTO.getPath());
        return Result.ok(ossToken);
    }
}
