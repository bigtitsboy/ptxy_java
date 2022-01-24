package com.ruoyi.operating.goods.secondhandGoods.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.system.image.domain.ImageUrl;
import com.ruoyi.system.image.service.IImageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operating.goods.secondhandGoods.mapper.SecondhandGoodsMapper;
import com.ruoyi.operating.goods.secondhandGoods.domain.SecondhandGoods;
import com.ruoyi.operating.goods.secondhandGoods.service.ISecondhandGoodsService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 二手商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@Service
public class SecondhandGoodsServiceImpl implements ISecondhandGoodsService 
{
    @Resource
    private SecondhandGoodsMapper secondhandGoodsMapper;

    @Autowired
    private IImageUrlService iImageUrlService;

    /**
     * 查询二手商品
     * 
     * @param goodsId 二手商品主键
     * @return 二手商品
     */
    @Override
    public SecondhandGoods selectSecondhandGoodsByGoodsId(Long goodsId)
    {
        //查询图片list
        SecondhandGoods goods = secondhandGoodsMapper.selectSecondhandGoodsByGoodsId(goodsId);
        if (StringUtils.isNotEmpty(goods.getImagePathId())){
            goods.setImageList(iImageUrlService.selectImageUrlByImagePathId(goods.getImagePathId()));
        }
        return  goods;
    }

    /**
     * 查询二手商品列表
     * 
     * @param secondhandGoods 二手商品
     * @return 二手商品
     */
    @Override
    public List<SecondhandGoods> selectSecondhandGoodsList(SecondhandGoods secondhandGoods)
    {
        List<SecondhandGoods> goodsList = secondhandGoodsMapper.selectSecondhandGoodsList(secondhandGoods);
        for (SecondhandGoods goods : goodsList) {
            //查询图片list
            if (StringUtils.isNotEmpty(goods.getImagePathId())){
                goods.setImageList(iImageUrlService.selectImageUrlByImagePathId(goods.getImagePathId()));
            }
        }
        return goodsList;
    }

    /**
     * 新增二手商品
     * 
     * @param secondhandGoods 二手商品
     * @return 结果
     */
    @Override
    public int insertSecondhandGoods(SecondhandGoods secondhandGoods)
    {
        //保存图片路径
        if (secondhandGoods.getImageList().size() > 0 ){
            ImageUrl url = new ImageUrl();
            String one=UUID.getUUId();
            for (String s : secondhandGoods.getImageList()) {
                url.setImagePathId(one);
                url.setImagePath(s);
                iImageUrlService.insertImageUrl(url);
            }
            secondhandGoods.setImagePathId(one);
        }
        //设置卖家ID
        LoginUser loginUser = SecurityUtils.getLoginUser();
        secondhandGoods.setUserId(loginUser.getUserId());
        secondhandGoods.setCreateTime(DateUtils.getNowDate());
        return secondhandGoodsMapper.insertSecondhandGoods(secondhandGoods);
    }

    /**
     * 修改二手商品
     * 
     * @param secondhandGoods 二手商品
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateSecondhandGoods(SecondhandGoods secondhandGoods)
    {
        if (secondhandGoods.getImageList().size() > 0){
            iImageUrlService.deleteImageUrlByImagePathId(secondhandGoods.getImagePathId());
            ImageUrl url = new ImageUrl();
            for (String s : secondhandGoods.getImageList()) {
                url.setImagePathId(secondhandGoods.getImagePathId());
                url.setImagePath(s);
                iImageUrlService.insertImageUrl(url);
            }
        }
        secondhandGoods.setUpdateTime(DateUtils.getNowDate());
        return secondhandGoodsMapper.updateSecondhandGoods(secondhandGoods);
    }

    /**
     * 批量删除二手商品
     * 
     * @param goodsIds 需要删除的二手商品主键
     * @return 结果
     */
    @Override
    public int deleteSecondhandGoodsByGoodsIds(Long[] goodsIds)
    {
        return secondhandGoodsMapper.deleteSecondhandGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除二手商品信息
     * 
     * @param goodsId 二手商品主键
     * @return 结果
     */
    @Override
    public int deleteSecondhandGoodsByGoodsId(Long goodsId)
    {
        return secondhandGoodsMapper.deleteSecondhandGoodsByGoodsId(goodsId);
    }
}
