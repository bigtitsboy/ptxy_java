package com.ruoyi.operating.goods.secondhandGoods.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 二手商品对象 secondhand_goods
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public class SecondhandGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String goodsContent;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal goodsPrice;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 图片路径ID */
    @Excel(name = "图片路径ID")
    private String imagePathId;

    /** 图片路径List */
    @Excel(name = "图片路径List")
    private List<String> imageList;

    /** 商品浏览量 */
    @Excel(name = "商品浏览量")
    private Long goodsCount;

    /** 商品状态（0正常 1停用） */
    @Excel(name = "商品状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setGoodsContent(String goodsContent) 
    {
        this.goodsContent = goodsContent;
    }

    public String getGoodsContent() 
    {
        return goodsContent;
    }
    public void setGoodsPrice(BigDecimal goodsPrice) 
    {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice() 
    {
        return goodsPrice;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }

    public String getImagePathId() {
        return imagePathId;
    }

    public void setImagePathId(String imagePathId) {
        this.imagePathId = imagePathId;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public void setGoodsCount(Long goodsCount)
    {
        this.goodsCount = goodsCount;
    }

    public Long getGoodsCount()
    {
        return goodsCount;
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
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsContent", getGoodsContent())
            .append("goodsPrice", getGoodsPrice())
            .append("categoryId", getCategoryId())
            .append("userId", getUserId())
            .append("phonenumber", getPhonenumber())
            .append("imagePathId", getImagePathId())
            .append("imageList", getImageList())
            .append("goodsCount", getGoodsCount())
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
