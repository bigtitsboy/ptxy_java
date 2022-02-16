package com.ruoyi.operating.goods.shopGoods.controller;

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
import com.ruoyi.operating.goods.shopGoods.domain.ShopGoods;
import com.ruoyi.operating.goods.shopGoods.service.IShopGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 店铺商品Controller
 * 
 * @author ruoyi
 * @date 2022-01-26
 */
@Api("店铺商品")
@RestController
@RequestMapping("/goods/shopGoods")
public class ShopGoodsController extends BaseController
{
    @Autowired
    private IShopGoodsService shopGoodsService;

    /**
     * 查询店铺商品列表
     */
    @ApiOperation("查询店铺商品列表")
    //@PreAuthorize("@ss.hasPermi('goods:shopGoods:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopGoods shopGoods)
    {
        startPage();
        List<ShopGoods> list = shopGoodsService.selectShopGoodsList(shopGoods);
        return getDataTable(list);
    }

    /**
     * 导出店铺商品列表
     */
    @ApiOperation("导出店铺商品列表")
//    @PreAuthorize("@ss.hasPermi('goods:shopGoods:export')")
    @Log(title = "店铺商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopGoods shopGoods)
    {
        List<ShopGoods> list = shopGoodsService.selectShopGoodsList(shopGoods);
        ExcelUtil<ShopGoods> util = new ExcelUtil<ShopGoods>(ShopGoods.class);
        util.exportExcel(response, list, "店铺商品数据");
    }

    /**
     * 获取店铺商品详细信息
     */
    @ApiOperation("获取店铺商品详细信息")
    //@PreAuthorize("@ss.hasPermi('goods:shopGoods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(shopGoodsService.selectShopGoodsByGoodsId(goodsId));
    }

    /**
     * 新增店铺商品
     */
    @ApiOperation("新增店铺商品")
    //@PreAuthorize("@ss.hasPermi('goods:shopGoods:add')")
    @Log(title = "店铺商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopGoods shopGoods)
    {
        return toAjax(shopGoodsService.insertShopGoods(shopGoods));
    }

    /**
     * 修改店铺商品
     */
    @ApiOperation("修改店铺商品")
    //@PreAuthorize("@ss.hasPermi('goods:shopGoods:edit')")
    @Log(title = "店铺商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopGoods shopGoods)
    {
        return toAjax(shopGoodsService.updateShopGoods(shopGoods));
    }

    /**
     * 删除店铺商品
     */
    @ApiOperation("删除店铺商品")
    //@PreAuthorize("@ss.hasPermi('goods:shopGoods:remove')")
    @Log(title = "店铺商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(shopGoodsService.deleteShopGoodsByGoodsIds(goodsIds));
    }
}
