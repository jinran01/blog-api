package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.entity.Talk;
import com.fiee.fieeblog.service.TalkService;
import com.fiee.fieeblog.utils.OssUtils;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.utils.UserUtils;
import com.fiee.fieeblog.vo.ConditionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

import static com.fiee.fieeblog.constant.OptTypeConst.REMOVE;
import static com.fiee.fieeblog.constant.OptTypeConst.SAVE_OR_UPDATE;
import static com.fiee.fieeblog.enums.FilePathEnum.ARTICLE_COVER;
import static com.fiee.fieeblog.enums.FilePathEnum.TALK_IMAGES;

/**
 * @Author: Fiee
 * @ClassName: TalkController
 * @Date: 2023/5/27
 * @Version: v1.0.0
 **/
@Api(tags = "说说管理")
@RestController
@RequestMapping("/admin")
public class TalkController {

    @Autowired
    private TalkService talkService;

    @Value("${upload.oss.endpoint}")
    public String endpoint;
    @Value("${upload.oss.accessKeySecret}")
    public String accessKeySecret;
    @Value("${upload.oss.accessKeyId}")
    public String accessKeyId;
    @Value("${upload.oss.bucketName}")
    public String bucketName;

    @ApiOperation("查看后台说说")
    @GetMapping("/talks")
    public Result getBackTalks(ConditionVO vo){
        return Result.ok(talkService.listBackTalks(vo));
    }

    @ApiOperation("根据id查看后台说说")
    @GetMapping("/talks/{id}")
    public Result getBackTalkById(@PathVariable Integer id){
        return Result.ok(talkService.getTalkById(id));
    }

    @OptLog(optType = REMOVE)
    @ApiOperation("删除说说")
    @DeleteMapping("/talks/{id}")
    public Result getBackTalks(@PathVariable Long id){
        return Result.ok(talkService.removeById(id));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation("保存或修改说说")
    @PostMapping("/talks")
    public Result getBackTalks(@RequestBody Talk talk){
        return Result.ok(talkService.saveOrUpdateTalk(talk));
    }

    @ApiOperation("上传说说图片")
    @GetMapping("/talks/images")
    public Result getOssToken() throws UnsupportedEncodingException {
        OssUtils ossUtils = new OssUtils();
        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName,TALK_IMAGES.getPath());
        return Result.ok(ossToken);
    }
}
