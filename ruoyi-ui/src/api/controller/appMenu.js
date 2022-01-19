import request from '@/utils/request'

// 查询移动端菜单列表
export function listAppMenu(query) {
  return request({
    url: '/controller/appMenu/list',
    method: 'get',
    params: query
  })
}

// 查询移动端菜单详细
export function getAppMenu(menuId) {
  return request({
    url: '/controller/appMenu/' + menuId,
    method: 'get'
  })
}

// 新增移动端菜单
export function addAppMenu(data) {
  return request({
    url: '/controller/appMenu',
    method: 'post',
    data: data
  })
}

// 修改移动端菜单
export function updateAppMenu(data) {
  return request({
    url: '/controller/appMenu',
    method: 'put',
    data: data
  })
}

// 删除移动端菜单
export function delAppMenu(menuId) {
  return request({
    url: '/controller/appMenu/' + menuId,
    method: 'delete'
  })
}
