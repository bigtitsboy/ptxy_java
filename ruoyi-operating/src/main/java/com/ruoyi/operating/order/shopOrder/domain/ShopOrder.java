package com.ruoyi.operating.order.shopOrder.domain;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品订单对象 shop_order
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@ApiModel("商品订单对象")
public class ShopOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品订单ID */

    private Long orderId;

    /** 商品ID */
    @ApiModelProperty("商品ID")
    @Excel(name = "商品ID")
    private Long goodsId;

    /** 商品数量 */
    @ApiModelProperty("商品数量")
    @Excel(name = "商品数量")
    private Long goodsNumber;

    /** 订单金额 */
    @ApiModelProperty("订单金额")
    @Excel(name = "订单金额")
    private BigDecimal orderPrice;

    /** 买家用户ID */
    @ApiModelProperty("买家用户ID")
    @Excel(name = "买家用户ID")
    private String buyerUserId;

    /** 收货人 */
    @ApiModelProperty("收货人")
    @Excel(name = "收货人")
    private String consignee;

    /** 详细地址 */
    @ApiModelProperty("详细地址")
    @Excel(name = "详细地址")
    private String addressContent;

    /** 手机号码 */
    @ApiModelProperty("手机号码")
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 订单状态（0待接单 1商家已接单 2配送中 3配送完成 4取消） */
    @ApiModelProperty("订单状态（0待接单 1商家已接单 2配送中 3配送完成 4取消）")
    @Excel(name = "订单状态", readConverterExp = "0=待接单,1=商家已接单,2=配送中,3=配送完成,4=取消")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }
    public void setGoodsNumber(Long goodsNumber) 
    {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsNumber() 
    {
        return goodsNumber;
    }
    public void setOrderPrice(BigDecimal orderPrice) 
    {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderPrice() 
    {
        return orderPrice;
    }
    public void setBuyerUserId(String buyerUserId) 
    {
        this.buyerUserId = buyerUserId;
    }

    public String getBuyerUserId() 
    {
        return buyerUserId;
    }
    public void setConsignee(String consignee) 
    {
        this.consignee = consignee;
    }

    public String getConsignee() 
    {
        return consignee;
    }
    public void setAddressContent(String addressContent) 
    {
        this.addressContent = addressContent;
    }

    public String getAddressContent() 
    {
        return addressContent;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("goodsId", getGoodsId())
            .append("goodsNumber", getGoodsNumber())
            .append("orderPrice", getOrderPrice())
            .append("buyerUserId", getBuyerUserId())
            .append("consignee", getConsignee())
            .append("addressContent", getAddressContent())
            .append("phonenumber", getPhonenumber())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
