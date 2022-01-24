package com.ruoyi.system.image.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.image.mapper.ImageUrlMapper;
import com.ruoyi.system.image.domain.ImageUrl;
import com.ruoyi.system.image.service.IImageUrlService;

/**
 * 图片路径Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-24
 */
@Service
public class ImageUrlServiceImpl implements IImageUrlService 
{
    @Autowired
    private ImageUrlMapper imageUrlMapper;

    /**
     * 查询图片路径
     * 
     * @param imagePathId 图片路径主键
     * @return 图片路径
     */
    @Override
    public List<String> selectImageUrlByImagePathId(String imagePathId)
    {
        return imageUrlMapper.selectImageUrlByImagePathId(imagePathId);
    }

    /**
     * 查询图片路径列表
     * 
     * @param imageUrl 图片路径
     * @return 图片路径
     */
    @Override
    public List<ImageUrl> selectImageUrlList(ImageUrl imageUrl)
    {
        return imageUrlMapper.selectImageUrlList(imageUrl);
    }

    /**
     * 新增图片路径
     * 
     * @param imageUrl 图片路径
     * @return 结果
     */
    @Override
    public int insertImageUrl(ImageUrl imageUrl)
    {
        return imageUrlMapper.insertImageUrl(imageUrl);
    }

    /**
     * 修改图片路径
     * 
     * @param imageUrl 图片路径
     * @return 结果
     */
    @Override
    public int updateImageUrl(ImageUrl imageUrl)
    {
        return imageUrlMapper.updateImageUrl(imageUrl);
    }

    /**
     * 批量删除图片路径
     * 
     * @param imagePathIds 需要删除的图片路径主键
     * @return 结果
     */
    @Override
    public int deleteImageUrlByImagePathIds(String[] imagePathIds)
    {
        return imageUrlMapper.deleteImageUrlByImagePathIds(imagePathIds);
    }

    /**
     * 删除图片路径信息
     * 
     * @param imagePathId 图片路径主键
     * @return 结果
     */
    @Override
    public int deleteImageUrlByImagePathId(String imagePathId)
    {
        return imageUrlMapper.deleteImageUrlByImagePathId(imagePathId);
    }
}
