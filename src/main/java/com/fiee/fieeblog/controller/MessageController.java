package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.annotation.AccessLimit;
import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.dto.MessageDTO;
import com.fiee.fieeblog.entity.Message;
import com.fiee.fieeblog.service.MessageService;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Fiee
 * @ClassName: MessageController
 * @Date: 2023/4/12
 * @Version: v1.0.0
 **/
@Api(tags = "留言管理")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation("查看留言列表")
    @GetMapping("/messages")
    public Result getHomeMessages(){
        return Result.ok(messageService.getMessage());
    }
    @ApiOperation("查看留言列表")
    @GetMapping("/admin/messages")
    public Result<PageResult<Message>> getBackMessages(ConditionVO vo){
        return Result.ok(messageService.getBackMessage(vo));
    }
    @ApiOperation("审核留言")
    @PutMapping("/admin/messages/review")
    public Result reviewMessages(@RequestBody List<Integer> ids){
        return Result.ok(messageService.reviewMessages(ids));
    }
    @ApiOperation("删除留言")
    @DeleteMapping("/admin/messages")
    public Result delMessages(@RequestBody List<Integer> ids){
        return Result.ok(messageService.removeBatchByIds(ids));
    }
    @ApiOperation("添加留言列表")
    @PostMapping("/messages")
    public Result addMessages(@RequestBody Message message, HttpServletRequest request){
        return Result.ok(messageService.saveMessage(message,request));
    }
}
