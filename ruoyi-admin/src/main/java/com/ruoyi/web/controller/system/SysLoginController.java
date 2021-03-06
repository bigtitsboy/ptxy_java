package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Set;

import com.ruoyi.common.core.domain.entity.Member;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.user.info.member.domain.MemberInfo;
import com.ruoyi.user.info.member.service.IMemberInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Api("登录验证")
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private IMemberInfoService iMemberInfoService;
    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation("pc端登录")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 移动端账号+密码登录
     *
     * @return
     */
    @ApiOperation("移动端账号+密码登录")
    @PostMapping("/api/pwd/login")
    public AjaxResult apiPwdLogin(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.apiLogin(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
    /**
     * 移动端手机+密码登录
     *
     * @return
     */
    @ApiOperation("移动端手机+密码登录")
    @PostMapping("/api/phone/login")
    public AjaxResult apiPhoneLogin(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.apiPhoneLogin(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 移动端邮箱+密码登录
     *
     * @return
     */
    @ApiOperation("移动端邮箱+密码登录")
    @PostMapping("/api/email/login")
    public AjaxResult apiEmailLogin(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.apiEmailLogin(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取移动端用户信息
     *
     * @return 用户信息
     */
    @ApiOperation("获取移动端用户信息")
    @GetMapping("/api/getInfo")
    public AjaxResult apiGetInfo()
    {
        Member member = SecurityUtils.getLoginUser().getMember();
        MemberInfo memberInfo = iMemberInfoService.selectMemberInfoByMemberId(member.getMemberId());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("member", memberInfo);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
