package com.ruoyi.operating.goods.goodsCategory.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operating.goods.goodsCategory.mapper.GoodsCategoryMapper;
import com.ruoyi.operating.goods.goodsCategory.domain.GoodsCategory;
import com.ruoyi.operating.goods.goodsCategory.service.IGoodsCategoryService;

/**
 * 商品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@Service
public class GoodsCategoryServiceImpl implements IGoodsCategoryService 
{
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    @Override
    public GoodsCategory selectGoodsCategoryByCategoryId(Long categoryId)
    {
        return goodsCategoryMapper.selectGoodsCategoryByCategoryId(categoryId);
    }

    /**
     * 查询商品分类列表
     * 
     * @param goodsCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<GoodsCategory> selectGoodsCategoryList(GoodsCategory goodsCategory)
    {
        return goodsCategoryMapper.selectGoodsCategoryList(goodsCategory);
    }

    /**
     * 新增商品分类
     * 
     * @param goodsCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertGoodsCategory(GoodsCategory goodsCategory)
    {
        goodsCategory.setCreateTime(DateUtils.getNowDate());
        return goodsCategoryMapper.insertGoodsCategory(goodsCategory);
    }

    /**
     * 修改商品分类
     * 
     * @param goodsCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateGoodsCategory(GoodsCategory goodsCategory)
    {
        goodsCategory.setUpdateTime(DateUtils.getNowDate());
        return goodsCategoryMapper.updateGoodsCategory(goodsCategory);
    }

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteGoodsCategoryByCategoryIds(Long[] categoryIds)
    {
        return goodsCategoryMapper.deleteGoodsCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除商品分类信息
     * 
     * @param categoryId 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteGoodsCategoryByCategoryId(Long categoryId)
    {
        return goodsCategoryMapper.deleteGoodsCategoryByCategoryId(categoryId);
    }
}
