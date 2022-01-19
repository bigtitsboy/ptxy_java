package com.ruoyi.web.controller.appMenu.service;

import java.util.List;
import com.ruoyi.web.controller.appMenu.domain.AppMenu;

/**
 * 移动端菜单Service接口
 * 
 * @author ruoyi
 * @date 2022-01-19
 */
public interface IAppMenuService 
{
    /**
     * 查询移动端菜单
     * 
     * @param menuId 移动端菜单主键
     * @return 移动端菜单
     */
    public AppMenu selectAppMenuByMenuId(Long menuId);

    /**
     * 查询移动端菜单列表
     * 
     * @param appMenu 移动端菜单
     * @return 移动端菜单集合
     */
    public List<AppMenu> selectAppMenuList(AppMenu appMenu);

    /**
     * 新增移动端菜单
     * 
     * @param appMenu 移动端菜单
     * @return 结果
     */
    public int insertAppMenu(AppMenu appMenu);

    /**
     * 修改移动端菜单
     * 
     * @param appMenu 移动端菜单
     * @return 结果
     */
    public int updateAppMenu(AppMenu appMenu);

    /**
     * 批量删除移动端菜单
     * 
     * @param menuIds 需要删除的移动端菜单主键集合
     * @return 结果
     */
    public int deleteAppMenuByMenuIds(Long[] menuIds);

    /**
     * 删除移动端菜单信息
     * 
     * @param menuId 移动端菜单主键
     * @return 结果
     */
    public int deleteAppMenuByMenuId(Long menuId);
}
