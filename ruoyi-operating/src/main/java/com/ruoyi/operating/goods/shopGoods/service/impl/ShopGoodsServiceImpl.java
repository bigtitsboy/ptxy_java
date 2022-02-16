package com.ruoyi.operating.goods.shopGoods.service.impl;

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
import com.ruoyi.operating.goods.shopGoods.mapper.ShopGoodsMapper;
import com.ruoyi.operating.goods.shopGoods.domain.ShopGoods;
import com.ruoyi.operating.goods.shopGoods.service.IShopGoodsService;

import javax.annotation.Resource;

/**
 * 店铺商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-26
 */
@Service
public class ShopGoodsServiceImpl implements IShopGoodsService 
{
    @Resource
    private ShopGoodsMapper shopGoodsMapper;

    @Autowired
    private IImageUrlService iImageUrlService;
    /**
     * 查询店铺商品
     * 
     * @param goodsId 店铺商品主键
     * @return 店铺商品
     */
    @Override
    public ShopGoods selectShopGoodsByGoodsId(Long goodsId)
    {
        //查询图片list
        ShopGoods goods = shopGoodsMapper.selectShopGoodsByGoodsId(goodsId);
        if (StringUtils.isNotEmpty(goods.getImagePathId())){
            goods.setImageList(iImageUrlService.selectImageUrlByImagePathId(goods.getImagePathId()));
        }
        //商品浏览量+1
        ShopGoods shopGoods = new ShopGoods();
        shopGoods.setGoodsId(goodsId);
        shopGoods.setGoodsCount(goods.getGoodsCount() + 1L);
        updateShopGoods(shopGoods);
        return  goods;
    }

    /**
     * 查询店铺商品列表
     * 
     * @param shopGoods 店铺商品
     * @return 店铺商品
     */
    @Override
    public List<ShopGoods> selectShopGoodsList(ShopGoods shopGoods)
    {
        List<ShopGoods> goodsList = shopGoodsMapper.selectShopGoodsList(shopGoods);
        for (ShopGoods goods : goodsList) {
            //查询图片list
            if (StringUtils.isNotEmpty(goods.getImagePathId())){
                goods.setImageList(iImageUrlService.selectImageUrlByImagePathId(goods.getImagePathId()));
            }
        }
        return goodsList;
    }

    /**
     * 新增店铺商品
     * 
     * @param shopGoods 店铺商品
     * @return 结果
     */
    @Override
    public int insertShopGoods(ShopGoods shopGoods)
    {
        //保存图片路径
        if (shopGoods.getImageList() != null){
            ImageUrl url = new ImageUrl();
            String one= UUID.getUUId();
            for (String s : shopGoods.getImageList()) {
                url.setImagePathId(one);
                url.setImagePath(s);
                iImageUrlService.insertImageUrl(url);
            }
            shopGoods.setImagePathId(one);
        }
        //设置卖家ID
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser.getMember() != null){
            shopGoods.setUserId(loginUser.getMember().getMemberId());
        }else {
            shopGoods.setUserId("admin");
        }
        shopGoods.setCreateTime(DateUtils.getNowDate());
        return shopGoodsMapper.insertShopGoods(shopGoods);
    }

    /**
     * 修改店铺商品
     * 
     * @param shopGoods 店铺商品
     * @return 结果
     */
    @Override
    public int updateShopGoods(ShopGoods shopGoods)
    {
        if (shopGoods.getImageList() != null){
            iImageUrlService.deleteImageUrlByImagePathId(shopGoods.getImagePathId());
            ImageUrl url = new ImageUrl();
            for (String s : shopGoods.getImageList()) {
                url.setImagePathId(shopGoods.getImagePathId());
                url.setImagePath(s);
                iImageUrlService.insertImageUrl(url);
            }
        }
        shopGoods.setUpdateTime(DateUtils.getNowDate());
        return shopGoodsMapper.updateShopGoods(shopGoods);
    }

    /**
     * 批量删除店铺商品
     * 
     * @param goodsIds 需要删除的店铺商品主键
     * @return 结果
     */
    @Override
    public int deleteShopGoodsByGoodsIds(Long[] goodsIds)
    {
        return shopGoodsMapper.deleteShopGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除店铺商品信息
     * 
     * @param goodsId 店铺商品主键
     * @return 结果
     */
    @Override
    public int deleteShopGoodsByGoodsId(Long goodsId)
    {
        return shopGoodsMapper.deleteShopGoodsByGoodsId(goodsId);
    }
}
