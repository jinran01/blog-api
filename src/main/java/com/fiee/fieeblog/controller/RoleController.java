package com.fiee.fieeblog.controller;

import com.fiee.fieeblog.annotation.OptLog;
import com.fiee.fieeblog.entity.Role;
import com.fiee.fieeblog.service.RoleMenuService;
import com.fiee.fieeblog.service.RoleResourceService;
import com.fiee.fieeblog.service.RoleService;
import com.fiee.fieeblog.utils.Result;
import com.fiee.fieeblog.vo.ConditionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.fiee.fieeblog.constant.OptTypeConst.*;


/**
 * @Author: Fiee
 * @ClassName: RoleController
 * @Date: 2023/3/5
 * @Version: v1.0.0
 **/

@Api(tags = "权限管理")
@RestController
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private RoleResourceService roleResourceService;

    @ApiOperation("获取角色")
    @GetMapping("/roles")
    public Result getRole(ConditionVO condition) {
        return Result.ok(roleService.listRoles(condition));
    }

    @ApiOperation("获取角色菜单")
    @GetMapping("/role/menus/{id}")
    public Result getRoleMenus(@PathVariable Integer id) {
        return Result.ok(roleMenuService.getRoleMenus(id));
    }

    @ApiOperation("获取角色资源")
    @GetMapping("/role/resources")
    public Result getRoleResource(Role role) {
        return Result.ok(roleResourceService.getRoleResource(role));
    }

    @OptLog(optType = SAVE)
    @ApiOperation("添加角色")
    @PostMapping("/role")
    public Result addRole(@RequestBody Map map) {
        if (roleService.addRole(map)) {
            return Result.ok();
        } else {
            return Result.fail("添加失败！");
        }
    }
    @OptLog(optType = REMOVE)
    @ApiOperation("删除角色")
    @DeleteMapping("/roles")
    public Result delRole(@RequestBody List<Integer> roleIds) {
        roleService.delRoles(roleIds);
        return Result.ok();
    }
    @OptLog(optType = UPDATE)
    @ApiOperation("禁用角色")
    @PutMapping("/role")
    public Result removeRole(@RequestBody Role role) {
        if (roleService.removeRoles(role)) {
            return Result.ok();
        } else {
            return Result.fail("操作失败，该角色下有用户！");
        }
    }
    @OptLog(optType = UPDATE)
    @ApiOperation("更新角色菜单")
    @PostMapping("/role/menus")
    public Result updateMenus(@RequestBody Map map) {
        roleService.updateMenus(map);
        return Result.ok();
    }
    @OptLog(optType = UPDATE)
    @ApiOperation("更新角色资源")
    @PostMapping("/role/resources")
    public Result updateResources(@RequestBody Map map) {
        roleService.updateResources(map);
        return Result.ok();

    }
}
