package com.ruoyi.web.controller.appMenu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.appMenu.mapper.AppMenuMapper;
import com.ruoyi.web.controller.appMenu.domain.AppMenu;
import com.ruoyi.web.controller.appMenu.service.IAppMenuService;

/**
 * 移动端菜单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-19
 */
@Service
public class AppMenuServiceImpl implements IAppMenuService 
{
    @Autowired
    private AppMenuMapper appMenuMapper;

    /**
     * 查询移动端菜单
     * 
     * @param menuId 移动端菜单主键
     * @return 移动端菜单
     */
    @Override
    public AppMenu selectAppMenuByMenuId(Long menuId)
    {
        return appMenuMapper.selectAppMenuByMenuId(menuId);
    }

    /**
     * 查询移动端菜单列表
     * 
     * @param appMenu 移动端菜单
     * @return 移动端菜单
     */
    @Override
    public List<AppMenu> selectAppMenuList(AppMenu appMenu)
    {
        return appMenuMapper.selectAppMenuList(appMenu);
    }

    /**
     * 新增移动端菜单
     * 
     * @param appMenu 移动端菜单
     * @return 结果
     */
    @Override
    public int insertAppMenu(AppMenu appMenu)
    {
        appMenu.setCreateTime(DateUtils.getNowDate());
        return appMenuMapper.insertAppMenu(appMenu);
    }

    /**
     * 修改移动端菜单
     * 
     * @param appMenu 移动端菜单
     * @return 结果
     */
    @Override
    public int updateAppMenu(AppMenu appMenu)
    {
        appMenu.setUpdateTime(DateUtils.getNowDate());
        return appMenuMapper.updateAppMenu(appMenu);
    }

    /**
     * 批量删除移动端菜单
     * 
     * @param menuIds 需要删除的移动端菜单主键
     * @return 结果
     */
    @Override
    public int deleteAppMenuByMenuIds(Long[] menuIds)
    {
        return appMenuMapper.deleteAppMenuByMenuIds(menuIds);
    }

    /**
     * 删除移动端菜单信息
     * 
     * @param menuId 移动端菜单主键
     * @return 结果
     */
    @Override
    public int deleteAppMenuByMenuId(Long menuId)
    {
        return appMenuMapper.deleteAppMenuByMenuId(menuId);
    }
}
