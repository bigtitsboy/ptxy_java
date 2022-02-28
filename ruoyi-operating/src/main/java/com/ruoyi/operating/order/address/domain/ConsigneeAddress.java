package com.ruoyi.operating.order.address.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收货地址对象 consignee_address
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@ApiModel("收货地址对象")
public class ConsigneeAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收货地址ID */
    @ApiModelProperty("收货地址ID")
    private Long addressId;

    /** 用户ID */
    @ApiModelProperty("用户ID")
    @Excel(name = "用户ID")
    private String userId;

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

    /** 收货地址状态（0正常 1停用） */
    @ApiModelProperty("收货地址状态（0正常 1停用）")
    @Excel(name = "收货地址状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
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
            .append("addressId", getAddressId())
            .append("userId", getUserId())
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
