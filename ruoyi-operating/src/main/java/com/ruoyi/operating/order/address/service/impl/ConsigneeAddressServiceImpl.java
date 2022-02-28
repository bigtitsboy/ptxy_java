package com.ruoyi.operating.order.address.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operating.order.address.mapper.ConsigneeAddressMapper;
import com.ruoyi.operating.order.address.domain.ConsigneeAddress;
import com.ruoyi.operating.order.address.service.IConsigneeAddressService;

/**
 * 收货地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@Service
public class ConsigneeAddressServiceImpl implements IConsigneeAddressService 
{
    @Autowired
    private ConsigneeAddressMapper consigneeAddressMapper;

    /**
     * 查询收货地址
     * 
     * @param addressId 收货地址主键
     * @return 收货地址
     */
    @Override
    public ConsigneeAddress selectConsigneeAddressByAddressId(Long addressId)
    {
        return consigneeAddressMapper.selectConsigneeAddressByAddressId(addressId);
    }

    /**
     * 查询收货地址列表
     * 
     * @param consigneeAddress 收货地址
     * @return 收货地址
     */
    @Override
    public List<ConsigneeAddress> selectConsigneeAddressList(ConsigneeAddress consigneeAddress)
    {
        return consigneeAddressMapper.selectConsigneeAddressList(consigneeAddress);
    }

    /**
     * 新增收货地址
     * 
     * @param consigneeAddress 收货地址
     * @return 结果
     */
    @Override
    public int insertConsigneeAddress(ConsigneeAddress consigneeAddress)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser.getMember() != null){
            consigneeAddress.setUserId(loginUser.getMember().getMemberId());
        }else {
            consigneeAddress.setUserId("admin");
        }
        consigneeAddress.setCreateTime(DateUtils.getNowDate());
        return consigneeAddressMapper.insertConsigneeAddress(consigneeAddress);
    }

    /**
     * 修改收货地址
     * 
     * @param consigneeAddress 收货地址
     * @return 结果
     */
    @Override
    public int updateConsigneeAddress(ConsigneeAddress consigneeAddress)
    {
        consigneeAddress.setUpdateTime(DateUtils.getNowDate());
        return consigneeAddressMapper.updateConsigneeAddress(consigneeAddress);
    }

    /**
     * 批量删除收货地址
     * 
     * @param addressIds 需要删除的收货地址主键
     * @return 结果
     */
    @Override
    public int deleteConsigneeAddressByAddressIds(Long[] addressIds)
    {
        return consigneeAddressMapper.deleteConsigneeAddressByAddressIds(addressIds);
    }

    /**
     * 删除收货地址信息
     * 
     * @param addressId 收货地址主键
     * @return 结果
     */
    @Override
    public int deleteConsigneeAddressByAddressId(Long addressId)
    {
        return consigneeAddressMapper.deleteConsigneeAddressByAddressId(addressId);
    }
}
