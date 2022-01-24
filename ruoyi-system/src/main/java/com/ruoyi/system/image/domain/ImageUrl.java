package com.ruoyi.system.image.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片路径对象 image_url
 * 
 * @author ruoyi
 * @date 2022-01-24
 */
public class ImageUrl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片路径id */
    @Excel(name = "图片路径id")
    private String imagePathId;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imagePath;

    public void setImagePathId(String imagePathId) 
    {
        this.imagePathId = imagePathId;
    }

    public String getImagePathId() 
    {
        return imagePathId;
    }
    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imagePathId", getImagePathId())
            .append("imagePath", getImagePath())
            .toString();
    }
}
