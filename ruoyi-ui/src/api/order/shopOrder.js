import request from '@/utils/request'

// 查询商品订单列表
export function listShopOrder(query) {
  return request({
    url: '/order/shopOrder/list',
    method: 'get',
    params: query
  })
}

// 查询商品订单详细
export function getShopOrder(orderId) {
  return request({
    url: '/order/shopOrder/' + orderId,
    method: 'get'
  })
}

// 新增商品订单
export function addShopOrder(data) {
  return request({
    url: '/order/shopOrder',
    method: 'post',
    data: data
  })
}

// 修改商品订单
export function updateShopOrder(data) {
  return request({
    url: '/order/shopOrder',
    method: 'put',
    data: data
  })
}

// 删除商品订单
export function delShopOrder(orderId) {
  return request({
    url: '/order/shopOrder/' + orderId,
    method: 'delete'
  })
}
