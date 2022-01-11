package com.ruoyi.operating.goods.secondhandGoods.controller;

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
import com.ruoyi.operating.goods.secondhandGoods.domain.SecondhandGoods;
import com.ruoyi.operating.goods.secondhandGoods.service.ISecondhandGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 二手商品Controller
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@RestController
@RequestMapping("/goods/secondhandGoods")
public class SecondhandGoodsController extends BaseController
{
    @Autowired
    private ISecondhandGoodsService secondhandGoodsService;

    /**
     * 查询二手商品列表
     */
    @PreAuthorize("@ss.hasPermi('goods:secondhandGoods:list')")
    @GetMapping("/list")
    public TableDataInfo list(SecondhandGoods secondhandGoods)
    {
        startPage();
        List<SecondhandGoods> list = secondhandGoodsService.selectSecondhandGoodsList(secondhandGoods);
        return getDataTable(list);
    }

    /**
     * 导出二手商品列表
     */
    @PreAuthorize("@ss.hasPermi('goods:secondhandGoods:export')")
    @Log(title = "二手商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SecondhandGoods secondhandGoods)
    {
        List<SecondhandGoods> list = secondhandGoodsService.selectSecondhandGoodsList(secondhandGoods);
        ExcelUtil<SecondhandGoods> util = new ExcelUtil<SecondhandGoods>(SecondhandGoods.class);
        util.exportExcel(response, list, "二手商品数据");
    }

    /**
     * 获取二手商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('goods:secondhandGoods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(secondhandGoodsService.selectSecondhandGoodsByGoodsId(goodsId));
    }

    /**
     * 新增二手商品
     */
    @PreAuthorize("@ss.hasPermi('goods:secondhandGoods:add')")
    @Log(title = "二手商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SecondhandGoods secondhandGoods)
    {
        return toAjax(secondhandGoodsService.insertSecondhandGoods(secondhandGoods));
    }

    /**
     * 修改二手商品
     */
    @PreAuthorize("@ss.hasPermi('goods:secondhandGoods:edit')")
    @Log(title = "二手商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SecondhandGoods secondhandGoods)
    {
        return toAjax(secondhandGoodsService.updateSecondhandGoods(secondhandGoods));
    }

    /**
     * 删除二手商品
     */
    @PreAuthorize("@ss.hasPermi('goods:secondhandGoods:remove')")
    @Log(title = "二手商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(secondhandGoodsService.deleteSecondhandGoodsByGoodsIds(goodsIds));
    }
}
