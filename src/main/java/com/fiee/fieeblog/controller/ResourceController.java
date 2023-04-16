package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.entity.Resource;
import com.fiee.fieeblog.service.ResourceService;
import com.fiee.fieeblog.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import static com.fiee.fieeblog.constant.OptTypeConst.*;


/**
 * @Author: Fiee
 * @ClassName: ResourceController
 * @Date: 2023/3/7
 * @Version: v1.0.0
 **/
@Api(tags = "资源管理")
@RestController
@RequestMapping("/admin")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("资源列表")
    @GetMapping("/resources")
    public Result getResourceList(@RequestParam String resourceName){
        return Result.ok(resourceService.getResourceList(resourceName));
    }

//    @ApiOperation("资源查询")
//    @GetMapping("/resource")
//    public Result searchResource(@RequestParam String resourceName){
//        return Result.ok(resourceService.getResource(resourceName));
//    }
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation("新增或修改资源")
    @PostMapping ("/resources")
    public Result updateResource(@RequestBody Resource resource){
        return Result.ok(resourceService.updateResource(resource));
    }
    @OptLog(optType = REMOVE)
    @ApiOperation("删除资源")
    @DeleteMapping ("/resources/{id}")
    public Result updateResource(@PathVariable Integer id){
        return Result.ok(resourceService.delResource(id));
    }
}
