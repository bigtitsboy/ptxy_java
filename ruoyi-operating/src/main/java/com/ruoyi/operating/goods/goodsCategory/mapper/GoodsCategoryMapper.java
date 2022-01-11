package com.ruoyi.operating.goods.goodsCategory.mapper;

import java.util.List;
import com.ruoyi.operating.goods.goodsCategory.domain.GoodsCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public interface GoodsCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    public GoodsCategory selectGoodsCategoryByCategoryId(Long categoryId);

    /**
     * 查询商品分类列表
     * 
     * @param goodsCategory 商品分类
     * @return 商品分类集合
     */
    public List<GoodsCategory> selectGoodsCategoryList(GoodsCategory goodsCategory);

    /**
     * 新增商品分类
     * 
     * @param goodsCategory 商品分类
     * @return 结果
     */
    public int insertGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 修改商品分类
     * 
     * @param goodsCategory 商品分类
     * @return 结果
     */
    public int updateGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 删除商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 结果
     */
    public int deleteGoodsCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsCategoryByCategoryIds(Long[] categoryIds);
}
