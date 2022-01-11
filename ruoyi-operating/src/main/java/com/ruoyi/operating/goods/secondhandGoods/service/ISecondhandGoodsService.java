package com.ruoyi.operating.goods.secondhandGoods.service;

import java.util.List;
import com.ruoyi.operating.goods.secondhandGoods.domain.SecondhandGoods;

/**
 * 二手商品Service接口
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public interface ISecondhandGoodsService 
{
    /**
     * 查询二手商品
     * 
     * @param goodsId 二手商品主键
     * @return 二手商品
     */
    public SecondhandGoods selectSecondhandGoodsByGoodsId(Long goodsId);

    /**
     * 查询二手商品列表
     * 
     * @param secondhandGoods 二手商品
     * @return 二手商品集合
     */
    public List<SecondhandGoods> selectSecondhandGoodsList(SecondhandGoods secondhandGoods);

    /**
     * 新增二手商品
     * 
     * @param secondhandGoods 二手商品
     * @return 结果
     */
    public int insertSecondhandGoods(SecondhandGoods secondhandGoods);

    /**
     * 修改二手商品
     * 
     * @param secondhandGoods 二手商品
     * @return 结果
     */
    public int updateSecondhandGoods(SecondhandGoods secondhandGoods);

    /**
     * 批量删除二手商品
     * 
     * @param goodsIds 需要删除的二手商品主键集合
     * @return 结果
     */
    public int deleteSecondhandGoodsByGoodsIds(Long[] goodsIds);

    /**
     * 删除二手商品信息
     * 
     * @param goodsId 二手商品主键
     * @return 结果
     */
    public int deleteSecondhandGoodsByGoodsId(Long goodsId);
}
