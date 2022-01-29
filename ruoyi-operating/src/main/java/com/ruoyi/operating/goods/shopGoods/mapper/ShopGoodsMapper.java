package com.ruoyi.operating.goods.shopGoods.mapper;

import java.util.List;
import com.ruoyi.operating.goods.shopGoods.domain.ShopGoods;

/**
 * 店铺商品Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-26
 */
public interface ShopGoodsMapper 
{
    /**
     * 查询店铺商品
     * 
     * @param goodsId 店铺商品主键
     * @return 店铺商品
     */
    public ShopGoods selectShopGoodsByGoodsId(Long goodsId);

    /**
     * 查询店铺商品列表
     * 
     * @param shopGoods 店铺商品
     * @return 店铺商品集合
     */
    public List<ShopGoods> selectShopGoodsList(ShopGoods shopGoods);

    /**
     * 新增店铺商品
     * 
     * @param shopGoods 店铺商品
     * @return 结果
     */
    public int insertShopGoods(ShopGoods shopGoods);

    /**
     * 修改店铺商品
     * 
     * @param shopGoods 店铺商品
     * @return 结果
     */
    public int updateShopGoods(ShopGoods shopGoods);

    /**
     * 删除店铺商品
     * 
     * @param goodsId 店铺商品主键
     * @return 结果
     */
    public int deleteShopGoodsByGoodsId(Long goodsId);

    /**
     * 批量删除店铺商品
     * 
     * @param goodsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopGoodsByGoodsIds(Long[] goodsIds);
}
