package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.entity.Menu;
import com.fiee.fieeblog.service.MenuService;
import com.fiee.fieeblog.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.fiee.fieeblog.constant.OptTypeConst.*;

/**
 * @Author: Fiee
 * @ClassName: MenuController
 * @Date: 2023/3/1
 * @Version: v1.0.0
 **/
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation("菜单列表")
    @GetMapping("/menus")
    public Result getUserList(@RequestParam String menuName){
        return Result.ok(menuService.getMenuList(menuName));
    }
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation("更新或新增菜单")
    @PostMapping("/menus")
    public Result getUserList(@RequestBody Menu menu){
        return Result.ok(menuService.updateMenu(menu));
    }

    @OptLog(optType = REMOVE)
    @ApiOperation("删除菜单")
    @DeleteMapping("/menus/{id}")
    public Result getUserList(@PathVariable Integer id){
        return Result.ok(menuService.delMenu(id));
    }

}
