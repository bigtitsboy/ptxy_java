package com.ruoyi.operating.order.shopOrder.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operating.order.shopOrder.mapper.ShopOrderMapper;
import com.ruoyi.operating.order.shopOrder.domain.ShopOrder;
import com.ruoyi.operating.order.shopOrder.service.IShopOrderService;

/**
 * 商品订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService 
{
    @Autowired
    private ShopOrderMapper shopOrderMapper;

    /**
     * 查询商品订单
     * 
     * @param orderId 商品订单主键
     * @return 商品订单
     */
    @Override
    public ShopOrder selectShopOrderByOrderId(Long orderId)
    {
        return shopOrderMapper.selectShopOrderByOrderId(orderId);
    }

    /**
     * 查询商品订单列表
     * 
     * @param shopOrder 商品订单
     * @return 商品订单
     */
    @Override
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder)
    {
        return shopOrderMapper.selectShopOrderList(shopOrder);
    }

    /**
     * 新增商品订单
     * 
     * @param shopOrder 商品订单
     * @return 结果
     */
    @Override
    public int insertShopOrder(ShopOrder shopOrder)
    {
        shopOrder.setCreateTime(DateUtils.getNowDate());
        return shopOrderMapper.insertShopOrder(shopOrder);
    }

    /**
     * 修改商品订单
     * 
     * @param shopOrder 商品订单
     * @return 结果
     */
    @Override
    public int updateShopOrder(ShopOrder shopOrder)
    {
        shopOrder.setUpdateTime(DateUtils.getNowDate());
        return shopOrderMapper.updateShopOrder(shopOrder);
    }

    /**
     * 批量删除商品订单
     * 
     * @param orderIds 需要删除的商品订单主键
     * @return 结果
     */
    @Override
    public int deleteShopOrderByOrderIds(Long[] orderIds)
    {
        return shopOrderMapper.deleteShopOrderByOrderIds(orderIds);
    }

    /**
     * 删除商品订单信息
     * 
     * @param orderId 商品订单主键
     * @return 结果
     */
    @Override
    public int deleteShopOrderByOrderId(Long orderId)
    {
        return shopOrderMapper.deleteShopOrderByOrderId(orderId);
    }
}
