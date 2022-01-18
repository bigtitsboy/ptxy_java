package com.ruoyi.web.controller.appMenu.mapper;

import java.util.List;

import com.ruoyi.web.controller.appMenu.domain.AppMenu;
import org.apache.ibatis.annotations.Param;

/**
 * 移动端菜单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-18
 */
public interface AppMenuMapper 
{
    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<AppMenu> selectMenuList(AppMenu menu);


    /**
     * 根据用户查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<AppMenu> selectMenuListByUserId(AppMenu menu);


    /**
     * 根据用户ID查询菜单
     *
     * @return 菜单列表
     */
    public List<AppMenu> selectMenuTreeAll();

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<AppMenu> selectMenuTreeByUserId(Long userId);


    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public AppMenu selectMenuById(Long menuId);

    /**
     * 是否存在菜单子节点
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int hasChildByMenuId(Long menuId);

    /**
     * 新增菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(AppMenu menu);

    /**
     * 修改菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(AppMenu menu);

    /**
     * 删除菜单管理信息
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 校验菜单名称是否唯一
     *
     * @param menuName 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public AppMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}
