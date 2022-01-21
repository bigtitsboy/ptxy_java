package com.ruoyi.web.controller.appMenu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.appMenu.domain.AppMenu;
import com.ruoyi.web.controller.appMenu.service.IAppMenuService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 移动端菜单Controller
 * 
 * @author ruoyi
 * @date 2022-01-19
 */
@Api("移动端菜单")
@RestController
@RequestMapping("/controller/appMenu")
public class AppMenuController extends BaseController
{
    @Autowired
    private IAppMenuService appMenuService;

    /**
     * 查询移动端菜单列表
     */
    @ApiOperation("查询移动端菜单列表")
    //@PreAuthorize("@ss.hasPermi('controller:appMenu:list')")
    @GetMapping("/list")
    public AjaxResult list(AppMenu appMenu)
    {
        List<AppMenu> list = appMenuService.selectAppMenuList(appMenu);
        return AjaxResult.success(list);
    }
    /**
     * 查询移动端菜单列表
     */
    @ApiOperation("查询移动端菜单列表")
    //@PreAuthorize("@ss.hasPermi('controller:appMenu:list')")
    @PostMapping("/list")
    public AjaxResult postList(@RequestBody AppMenu appMenu)
    {
        List<AppMenu> list = appMenuService.selectAppMenuList(appMenu);
        return AjaxResult.success(list);
    }

    /**
     * 导出移动端菜单列表
     */
    @ApiOperation("导出移动端菜单列表")
    @PreAuthorize("@ss.hasPermi('controller:appMenu:export')")
    @Log(title = "移动端菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppMenu appMenu)
    {
        List<AppMenu> list = appMenuService.selectAppMenuList(appMenu);
        ExcelUtil<AppMenu> util = new ExcelUtil<AppMenu>(AppMenu.class);
        util.exportExcel(response, list, "移动端菜单数据");
    }

    /**
     * 获取移动端菜单详细信息
     */
    @ApiOperation("获取移动端菜单详细信息")
    @PreAuthorize("@ss.hasPermi('controller:appMenu:query')")
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable("menuId") Long menuId)
    {
        return AjaxResult.success(appMenuService.selectAppMenuByMenuId(menuId));
    }

    /**
     * 新增移动端菜单
     */
    @ApiOperation("新增移动端菜单")
    @PreAuthorize("@ss.hasPermi('controller:appMenu:add')")
    @Log(title = "移动端菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppMenu appMenu)
    {
        return toAjax(appMenuService.insertAppMenu(appMenu));
    }

    /**
     * 修改移动端菜单
     */
    @ApiOperation("修改移动端菜单")
    @PreAuthorize("@ss.hasPermi('controller:appMenu:edit')")
    @Log(title = "移动端菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppMenu appMenu)
    {
        return toAjax(appMenuService.updateAppMenu(appMenu));
    }

    /**
     * 删除移动端菜单
     */
    @ApiOperation("删除移动端菜单")
    @PreAuthorize("@ss.hasPermi('controller:appMenu:remove')")
    @Log(title = "移动端菜单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{menuIds}")
    public AjaxResult remove(@PathVariable Long[] menuIds)
    {
        return toAjax(appMenuService.deleteAppMenuByMenuIds(menuIds));
    }
}
