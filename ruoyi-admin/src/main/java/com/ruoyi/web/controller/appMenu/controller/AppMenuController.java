package com.ruoyi.web.controller.appMenu.controller;


import java.util.List;

import com.ruoyi.web.controller.appMenu.domain.AppMenu;
import com.ruoyi.web.controller.appMenu.service.IAppMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;

/**
 * 移动端菜单Controller
 * 
 * @author ruoyi
 * @date 2022-01-18
 */

@Api("移动端菜单")
@RestController
@RequestMapping("/controller/appMenu")
public class AppMenuController extends BaseController
{
    @Autowired
    private IAppMenuService appMenuService;
    

    /**
     * 获取菜单列表
     */
    @ApiOperation("获取菜单列表")
    @PreAuthorize("@ss.hasPermi('system:appMenu:list')")
    @GetMapping("/list")
    public AjaxResult list(AppMenu menu)
    {
        List<AppMenu> menus = appMenuService.selectMenuList(menu, getUserId());
        return AjaxResult.success(menus);
    }

    /**
     * 根据菜单编号获取详细信息
     */
    @ApiOperation("根据菜单编号获取详细信息")
    @PreAuthorize("@ss.hasPermi('system:appMenu:query')")
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable Long menuId)
    {
        return AjaxResult.success(appMenuService.selectMenuById(menuId));
    }

    /**
     * 获取菜单下拉树列表
     */
    @ApiOperation("获取菜单下拉树列表")
    @GetMapping("/treeselect")
    public AjaxResult treeselect(AppMenu menu)
    {
        List<AppMenu> menus = appMenuService.selectMenuList(menu, getUserId());
        return AjaxResult.success(appMenuService.buildMenuTreeSelect(menus));
    }


    /**
     * 新增菜单
     */
    @ApiOperation("新增菜单")
    @PreAuthorize("@ss.hasPermi('system:appMenu:add')")
    @Log(title = "移动菜单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody AppMenu menu)
    {
        if (UserConstants.NOT_UNIQUE.equals(appMenuService.checkMenuNameUnique(menu)))
        {
            return AjaxResult.error("新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath()))
        {
            return AjaxResult.error("新增菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        }
        menu.setCreateBy(getUsername());
        return toAjax(appMenuService.insertMenu(menu));
    }

    /**
     * 修改菜单
     */
    @ApiOperation("修改菜单")
    @PreAuthorize("@ss.hasPermi('system:appMenu:edit')")
    @Log(title = "移动菜单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody AppMenu menu)
    {
        if (UserConstants.NOT_UNIQUE.equals(appMenuService.checkMenuNameUnique(menu)))
        {
            return AjaxResult.error("修改菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath()))
        {
            return AjaxResult.error("修改菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        }
        else if (menu.getMenuId().equals(menu.getParentId()))
        {
            return AjaxResult.error("修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        menu.setUpdateBy(getUsername());
        return toAjax(appMenuService.updateMenu(menu));
    }

    /**
     * 删除菜单
     */
    @ApiOperation("删除菜单")
    @PreAuthorize("@ss.hasPermi('system:appMenu:remove')")
    @Log(title = "移动菜单管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{menuId}")
    public AjaxResult remove(@PathVariable("menuId") Long menuId)
    {
        if (appMenuService.hasChildByMenuId(menuId))
        {
            return AjaxResult.error("存在子菜单,不允许删除");
        }
        return toAjax(appMenuService.deleteMenuById(menuId));
    }
}