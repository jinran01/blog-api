package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.entity.Talk;
import com.fiee.fieeblog.service.TalkService;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static com.fiee.fieeblog.constant.OptTypeConst.REMOVE;
import static com.fiee.fieeblog.constant.OptTypeConst.SAVE_OR_UPDATE;

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

    @ApiOperation("查看后台说说")
    @GetMapping("/talks")
    public Result getBackTalks(){
        return Result.ok();
    }

    @ApiOperation("根据id查看后台说说")
    @GetMapping("/talks/{id}")
    public Result getBackTalkById(@PathVariable Integer id){
        return Result.ok(talkService.getById(id));
    }

    @OptLog(optType = REMOVE)
    @ApiOperation("删除说说")
    @DeleteMapping("/talks")
    public Result getBackTalks(@RequestBody Long[] ids){
        return Result.ok(talkService.removeByIds(Arrays.asList(ids)));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation("保存或修改说说")
    @PostMapping("/talks")
    public Result getBackTalks(@RequestBody Talk talk){
        return Result.ok(talkService.saveOrUpdateTalk(talk));
    }

}
