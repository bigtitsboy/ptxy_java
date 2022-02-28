package com.ruoyi.operating.order.address.controller;

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
import com.ruoyi.operating.order.address.domain.ConsigneeAddress;
import com.ruoyi.operating.order.address.service.IConsigneeAddressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收货地址Controller
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@Api("收货地址")
@RestController
@RequestMapping("/order/address")
public class ConsigneeAddressController extends BaseController
{
    @Autowired
    private IConsigneeAddressService consigneeAddressService;

    /**
     * 查询收货地址列表
     */
    @ApiOperation("查询收货地址列表")
//    @PreAuthorize("@ss.hasPermi('order:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(ConsigneeAddress consigneeAddress)
    {
        startPage();
        List<ConsigneeAddress> list = consigneeAddressService.selectConsigneeAddressList(consigneeAddress);
        return getDataTable(list);
    }

    /**
     * 导出收货地址列表
     */
    @ApiOperation("导出收货地址列表")
//    @PreAuthorize("@ss.hasPermi('order:address:export')")
    @Log(title = "收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ConsigneeAddress consigneeAddress)
    {
        List<ConsigneeAddress> list = consigneeAddressService.selectConsigneeAddressList(consigneeAddress);
        ExcelUtil<ConsigneeAddress> util = new ExcelUtil<ConsigneeAddress>(ConsigneeAddress.class);
        util.exportExcel(response, list, "收货地址数据");
    }

    /**
     * 获取收货地址详细信息
     */
    @ApiOperation("获取收货地址详细信息")
//    @PreAuthorize("@ss.hasPermi('order:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return AjaxResult.success(consigneeAddressService.selectConsigneeAddressByAddressId(addressId));
    }

    /**
     * 新增收货地址
     */
    @ApiOperation("新增收货地址")
//    @PreAuthorize("@ss.hasPermi('order:address:add')")
    @Log(title = "收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ConsigneeAddress consigneeAddress)
    {
        return toAjax(consigneeAddressService.insertConsigneeAddress(consigneeAddress));
    }

    /**
     * 修改收货地址
     */
    @ApiOperation("修改收货地址")
//    @PreAuthorize("@ss.hasPermi('order:address:edit')")
    @Log(title = "收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ConsigneeAddress consigneeAddress)
    {
        return toAjax(consigneeAddressService.updateConsigneeAddress(consigneeAddress));
    }

    /**
     * 删除收货地址
     */
    @ApiOperation("删除收货地址")
//    @PreAuthorize("@ss.hasPermi('order:address:remove')")
    @Log(title = "收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds)
    {
        return toAjax(consigneeAddressService.deleteConsigneeAddressByAddressIds(addressIds));
    }
}
