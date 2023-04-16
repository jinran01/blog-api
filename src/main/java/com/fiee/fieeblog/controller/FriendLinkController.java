package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.entity.FriendLink;
import com.fiee.fieeblog.service.FriendLinkService;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.ConditionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Fiee
 * @ClassName: FriendLinkController
 * @Date: 2023/4/8
 * @Version: v1.0.0
 **/
@Api(tags = "友链管理")
@RestController
public class FriendLinkController {
    @Autowired
    private FriendLinkService friendLinkService;

    @ApiOperation("获取友链列表")
    @GetMapping("/links")
    public Result getLinks(ConditionVO vo){
        return Result.ok(friendLinkService.getFriendLinks(vo));
    }

    @ApiOperation("保存或更新友链")
    @PostMapping("/links")
    public Result addOrUpdateLinks(@RequestBody FriendLink friendLink){
        return Result.ok(friendLinkService.saveOrUpdate(friendLink));
    }

    @ApiOperation("删除友链")
    @DeleteMapping ("/links")
    public Result delLinks(@RequestBody List<Integer> ids){
        return Result.ok(friendLinkService.removeBatchByIds(ids));
    }
}
