package com.ruoyi.operating.order.shopOrder.service;

import java.util.List;
import com.ruoyi.operating.order.shopOrder.domain.ShopOrder;

/**
 * 商品订单Service接口
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
public interface IShopOrderService 
{
    /**
     * 查询商品订单
     * 
     * @param orderId 商品订单主键
     * @return 商品订单
     */
    public ShopOrder selectShopOrderByOrderId(Long orderId);

    /**
     * 查询商品订单列表
     * 
     * @param shopOrder 商品订单
     * @return 商品订单集合
     */
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder);

    /**
     * 新增商品订单
     * 
     * @param shopOrder 商品订单
     * @return 结果
     */
    public int insertShopOrder(ShopOrder shopOrder);

    /**
     * 修改商品订单
     * 
     * @param shopOrder 商品订单
     * @return 结果
     */
    public int updateShopOrder(ShopOrder shopOrder);

    /**
     * 批量删除商品订单
     * 
     * @param orderIds 需要删除的商品订单主键集合
     * @return 结果
     */
    public int deleteShopOrderByOrderIds(Long[] orderIds);

    /**
     * 删除商品订单信息
     * 
     * @param orderId 商品订单主键
     * @return 结果
     */
    public int deleteShopOrderByOrderId(Long orderId);
}
