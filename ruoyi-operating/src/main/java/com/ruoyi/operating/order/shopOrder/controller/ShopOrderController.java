package com.ruoyi.operating.order.shopOrder.controller;

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
import com.ruoyi.operating.order.shopOrder.domain.ShopOrder;
import com.ruoyi.operating.order.shopOrder.service.IShopOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品订单Controller
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@Api("商品订单")
@RestController
@RequestMapping("/order/shopOrder")
public class ShopOrderController extends BaseController
{
    @Autowired
    private IShopOrderService shopOrderService;

    /**
     * 查询商品订单列表
     */
    @ApiOperation("查询商品订单列表")
//    @PreAuthorize("@ss.hasPermi('order:shopOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopOrder shopOrder)
    {
        startPage();
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        return getDataTable(list);
    }

    /**
     * 导出商品订单列表
     */
    @ApiOperation("导出商品订单列表")
//    @PreAuthorize("@ss.hasPermi('order:shopOrder:export')")
    @Log(title = "商品订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopOrder shopOrder)
    {
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        ExcelUtil<ShopOrder> util = new ExcelUtil<ShopOrder>(ShopOrder.class);
        util.exportExcel(response, list, "商品订单数据");
    }

    /**
     * 获取商品订单详细信息
     */
    @ApiOperation("获取商品订单详细信息")
//    @PreAuthorize("@ss.hasPermi('order:shopOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(shopOrderService.selectShopOrderByOrderId(orderId));
    }

    /**
     * 新增商品订单
     */
    @ApiOperation("新增商品订单")
//    @PreAuthorize("@ss.hasPermi('order:shopOrder:add')")
    @Log(title = "商品订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopOrder shopOrder)
    {
        return toAjax(shopOrderService.insertShopOrder(shopOrder));
    }

    /**
     * 修改商品订单
     */
    @ApiOperation("修改商品订单")
//    @PreAuthorize("@ss.hasPermi('order:shopOrder:edit')")
    @Log(title = "商品订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopOrder shopOrder)
    {
        return toAjax(shopOrderService.updateShopOrder(shopOrder));
    }

    /**
     * 删除商品订单
     */
    @ApiOperation("删除商品订单")
//    @PreAuthorize("@ss.hasPermi('order:shopOrder:remove')")
    @Log(title = "商品订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(shopOrderService.deleteShopOrderByOrderIds(orderIds));
    }
}
