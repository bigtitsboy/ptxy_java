package com.ruoyi.user.info.member.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.user.info.member.domain.MemberInfo;
import com.ruoyi.user.info.member.service.IMemberInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员信息Controller
 * 
 * @author ruoyi
 * @date 2022-01-20
 */
@RestController
@RequestMapping("/info/member")
public class MemberInfoController extends BaseController
{
    @Autowired
    private IMemberInfoService memberInfoService;

    /**
     * 查询会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('info:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(MemberInfo memberInfo)
    {
        startPage();
        List<MemberInfo> list = memberInfoService.selectMemberInfoList(memberInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('info:member:export')")
    @Log(title = "会员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberInfo memberInfo)
    {
        List<MemberInfo> list = memberInfoService.selectMemberInfoList(memberInfo);
        ExcelUtil<MemberInfo> util = new ExcelUtil<MemberInfo>(MemberInfo.class);
        util.exportExcel(response, list, "会员信息数据");
    }

    /**
     * 获取会员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:member:query')")
    @GetMapping(value = "/{memberId}")
    public AjaxResult getInfo(@PathVariable("memberId") String memberId)
    {
        return AjaxResult.success(memberInfoService.selectMemberInfoByMemberId(memberId));
    }

    /**
     * 新增会员信息
     */
    @PreAuthorize("@ss.hasPermi('info:member:add')")
    @Log(title = "会员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberInfo memberInfo)
    {
        return toAjax(memberInfoService.insertMemberInfo(memberInfo));
    }

    /**
     * 修改会员信息
     */
    @PreAuthorize("@ss.hasPermi('info:member:edit')")
    @Log(title = "会员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberInfo memberInfo)
    {
        return toAjax(memberInfoService.updateMemberInfo(memberInfo));
    }

    /**
     * 删除会员信息
     */
    @PreAuthorize("@ss.hasPermi('info:member:remove')")
    @Log(title = "会员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memberIds}")
    public AjaxResult remove(@PathVariable String[] memberIds)
    {
        return toAjax(memberInfoService.deleteMemberInfoByMemberIds(memberIds));
    }
}
