import request from '@/utils/request'

// 查询店铺商品列表
export function listShopGoods(query) {
  return request({
    url: '/goods/shopGoods/list',
    method: 'get',
    params: query
  })
}

// 查询店铺商品详细
export function getShopGoods(goodsId) {
  return request({
    url: '/goods/shopGoods/' + goodsId,
    method: 'get'
  })
}

// 新增店铺商品
export function addShopGoods(data) {
  return request({
    url: '/goods/shopGoods',
    method: 'post',
    data: data
  })
}

// 修改店铺商品
export function updateShopGoods(data) {
  return request({
    url: '/goods/shopGoods',
    method: 'put',
    data: data
  })
}

// 删除店铺商品
export function delShopGoods(goodsId) {
  return request({
    url: '/goods/shopGoods/' + goodsId,
    method: 'delete'
  })
}
