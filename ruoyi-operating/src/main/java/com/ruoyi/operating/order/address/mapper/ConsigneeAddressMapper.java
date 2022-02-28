package com.ruoyi.operating.order.address.mapper;

import java.util.List;
import com.ruoyi.operating.order.address.domain.ConsigneeAddress;

/**
 * 收货地址Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
public interface ConsigneeAddressMapper 
{
    /**
     * 查询收货地址
     * 
     * @param addressId 收货地址主键
     * @return 收货地址
     */
    public ConsigneeAddress selectConsigneeAddressByAddressId(Long addressId);

    /**
     * 查询收货地址列表
     * 
     * @param consigneeAddress 收货地址
     * @return 收货地址集合
     */
    public List<ConsigneeAddress> selectConsigneeAddressList(ConsigneeAddress consigneeAddress);

    /**
     * 新增收货地址
     * 
     * @param consigneeAddress 收货地址
     * @return 结果
     */
    public int insertConsigneeAddress(ConsigneeAddress consigneeAddress);

    /**
     * 修改收货地址
     * 
     * @param consigneeAddress 收货地址
     * @return 结果
     */
    public int updateConsigneeAddress(ConsigneeAddress consigneeAddress);

    /**
     * 删除收货地址
     * 
     * @param addressId 收货地址主键
     * @return 结果
     */
    public int deleteConsigneeAddressByAddressId(Long addressId);

    /**
     * 批量删除收货地址
     * 
     * @param addressIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteConsigneeAddressByAddressIds(Long[] addressIds);
}
