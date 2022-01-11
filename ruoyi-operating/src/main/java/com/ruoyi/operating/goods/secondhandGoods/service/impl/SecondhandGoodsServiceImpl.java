package com.ruoyi.operating.goods.secondhandGoods.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operating.goods.secondhandGoods.mapper.SecondhandGoodsMapper;
import com.ruoyi.operating.goods.secondhandGoods.domain.SecondhandGoods;
import com.ruoyi.operating.goods.secondhandGoods.service.ISecondhandGoodsService;

/**
 * 二手商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@Service
public class SecondhandGoodsServiceImpl implements ISecondhandGoodsService 
{
    @Autowired
    private SecondhandGoodsMapper secondhandGoodsMapper;

    /**
     * 查询二手商品
     * 
     * @param goodsId 二手商品主键
     * @return 二手商品
     */
    @Override
    public SecondhandGoods selectSecondhandGoodsByGoodsId(Long goodsId)
    {
        return secondhandGoodsMapper.selectSecondhandGoodsByGoodsId(goodsId);
    }

    /**
     * 查询二手商品列表
     * 
     * @param secondhandGoods 二手商品
     * @return 二手商品
     */
    @Override
    public List<SecondhandGoods> selectSecondhandGoodsList(SecondhandGoods secondhandGoods)
    {
        return secondhandGoodsMapper.selectSecondhandGoodsList(secondhandGoods);
    }

    /**
     * 新增二手商品
     * 
     * @param secondhandGoods 二手商品
     * @return 结果
     */
    @Override
    public int insertSecondhandGoods(SecondhandGoods secondhandGoods)
    {
        secondhandGoods.setCreateTime(DateUtils.getNowDate());
        return secondhandGoodsMapper.insertSecondhandGoods(secondhandGoods);
    }

    /**
     * 修改二手商品
     * 
     * @param secondhandGoods 二手商品
     * @return 结果
     */
    @Override
    public int updateSecondhandGoods(SecondhandGoods secondhandGoods)
    {
        secondhandGoods.setUpdateTime(DateUtils.getNowDate());
        return secondhandGoodsMapper.updateSecondhandGoods(secondhandGoods);
    }

    /**
     * 批量删除二手商品
     * 
     * @param goodsIds 需要删除的二手商品主键
     * @return 结果
     */
    @Override
    public int deleteSecondhandGoodsByGoodsIds(Long[] goodsIds)
    {
        return secondhandGoodsMapper.deleteSecondhandGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除二手商品信息
     * 
     * @param goodsId 二手商品主键
     * @return 结果
     */
    @Override
    public int deleteSecondhandGoodsByGoodsId(Long goodsId)
    {
        return secondhandGoodsMapper.deleteSecondhandGoodsByGoodsId(goodsId);
    }
}
