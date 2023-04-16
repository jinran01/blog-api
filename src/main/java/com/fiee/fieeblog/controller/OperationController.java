package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.entity.Resource;
import com.fiee.fieeblog.service.OperationLogService;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.ConditionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Fiee
 * @ClassName: OperationController
 * @Date: 2023/3/26
 * @Version: v1.0.0
 **/
@Api(tags = "日志管理")
@RestController
@RequestMapping("/admin")
public class OperationController {
    @Autowired
    private OperationLogService operationLogService;

    @ApiOperation("操作日志列表")
    @GetMapping("/operation/logs")
    public Result getOperations(ConditionVO conditionVO){
        return Result.ok(operationLogService.getOperations(conditionVO));
    }

    @ApiOperation("删除操作日志")
    @DeleteMapping ("/operation/logs")
    public Result delOperations(@RequestBody List<Integer> ids){
        return Result.ok(operationLogService.delOperations(ids));
    }
}
