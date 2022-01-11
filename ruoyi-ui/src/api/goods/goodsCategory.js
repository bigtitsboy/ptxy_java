import request from '@/utils/request'

// 查询商品分类列表
export function listGoodsCategory(query) {
  return request({
    url: '/goods/goodsCategory/list',
    method: 'get',
    params: query
  })
}

// 查询商品分类详细
export function getGoodsCategory(categoryId) {
  return request({
    url: '/goods/goodsCategory/' + categoryId,
    method: 'get'
  })
}

// 新增商品分类
export function addGoodsCategory(data) {
  return request({
    url: '/goods/goodsCategory',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateGoodsCategory(data) {
  return request({
    url: '/goods/goodsCategory',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delGoodsCategory(categoryId) {
  return request({
    url: '/goods/goodsCategory/' + categoryId,
    method: 'delete'
  })
}
