package com.ruoyi.operating.goods.goodsCategory.controller;

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
import com.ruoyi.operating.goods.goodsCategory.domain.GoodsCategory;
import com.ruoyi.operating.goods.goodsCategory.service.IGoodsCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@Api("商品分类")
@RestController
@RequestMapping("/goods/goodsCategory")
public class GoodsCategoryController extends BaseController
{
    @Autowired
    private IGoodsCategoryService goodsCategoryService;

    /**
     * 查询商品分类列表
     */
    @ApiOperation("查询商品分类列表")
//    @PreAuthorize("@ss.hasPermi('goods:goodsCategory:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsCategory goodsCategory)
    {
        startPage();
        List<GoodsCategory> list = goodsCategoryService.selectGoodsCategoryList(goodsCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @ApiOperation("导出商品分类列表")
    @PreAuthorize("@ss.hasPermi('goods:goodsCategory:export')")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsCategory goodsCategory)
    {
        List<GoodsCategory> list = goodsCategoryService.selectGoodsCategoryList(goodsCategory);
        ExcelUtil<GoodsCategory> util = new ExcelUtil<GoodsCategory>(GoodsCategory.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @ApiOperation("获取商品分类详细信息")
    @PreAuthorize("@ss.hasPermi('goods:goodsCategory:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return AjaxResult.success(goodsCategoryService.selectGoodsCategoryByCategoryId(categoryId));
    }

    /**
     * 新增商品分类
     */
    @ApiOperation("新增商品分类")
    @PreAuthorize("@ss.hasPermi('goods:goodsCategory:add')")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsCategory goodsCategory)
    {
        return toAjax(goodsCategoryService.insertGoodsCategory(goodsCategory));
    }

    /**
     * 修改商品分类
     */
    @ApiOperation("修改商品分类")
    @PreAuthorize("@ss.hasPermi('goods:goodsCategory:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsCategory goodsCategory)
    {
        return toAjax(goodsCategoryService.updateGoodsCategory(goodsCategory));
    }

    /**
     * 删除商品分类
     */
    @ApiOperation("删除商品分类")
    @PreAuthorize("@ss.hasPermi('goods:goodsCategory:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(goodsCategoryService.deleteGoodsCategoryByCategoryIds(categoryIds));
    }
}
