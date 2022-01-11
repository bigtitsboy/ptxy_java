import request from '@/utils/request'

// 查询二手商品列表
export function listSecondhandGoods(query) {
  return request({
    url: '/goods/secondhandGoods/list',
    method: 'get',
    params: query
  })
}

// 查询二手商品详细
export function getSecondhandGoods(goodsId) {
  return request({
    url: '/goods/secondhandGoods/' + goodsId,
    method: 'get'
  })
}

// 新增二手商品
export function addSecondhandGoods(data) {
  return request({
    url: '/goods/secondhandGoods',
    method: 'post',
    data: data
  })
}

// 修改二手商品
export function updateSecondhandGoods(data) {
  return request({
    url: '/goods/secondhandGoods',
    method: 'put',
    data: data
  })
}

// 删除二手商品
export function delSecondhandGoods(goodsId) {
  return request({
    url: '/goods/secondhandGoods/' + goodsId,
    method: 'delete'
  })
}
