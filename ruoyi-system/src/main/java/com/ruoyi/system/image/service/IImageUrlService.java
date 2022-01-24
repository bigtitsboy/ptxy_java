package com.ruoyi.system.image.service;

import java.util.List;
import com.ruoyi.system.image.domain.ImageUrl;

/**
 * 图片路径Service接口
 * 
 * @author ruoyi
 * @date 2022-01-24
 */
public interface IImageUrlService 
{
    /**
     * 查询图片路径
     * 
     * @param imagePathId 图片路径主键
     * @return 图片路径
     */
    public List<String> selectImageUrlByImagePathId(String imagePathId);

    /**
     * 查询图片路径列表
     * 
     * @param imageUrl 图片路径
     * @return 图片路径集合
     */
    public List<ImageUrl> selectImageUrlList(ImageUrl imageUrl);

    /**
     * 新增图片路径
     * 
     * @param imageUrl 图片路径
     * @return 结果
     */
    public int insertImageUrl(ImageUrl imageUrl);

    /**
     * 修改图片路径
     * 
     * @param imageUrl 图片路径
     * @return 结果
     */
    public int updateImageUrl(ImageUrl imageUrl);

    /**
     * 批量删除图片路径
     * 
     * @param imagePathIds 需要删除的图片路径主键集合
     * @return 结果
     */
    public int deleteImageUrlByImagePathIds(String[] imagePathIds);

    /**
     * 删除图片路径信息
     * 
     * @param imagePathId 图片路径主键
     * @return 结果
     */
    public int deleteImageUrlByImagePathId(String imagePathId);
}
