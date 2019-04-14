/*
 * @Author: Book
 * @Date:   2018-07-02 16:19:16
 * @Last Modified by:   Book
 * @Last Modified time: 2018-07-03 14:54:41
 */

import axios from "@AXIOS_PATH/index.js";
import {
  Message as message
} from "element-ui";
//短信查看
export const URL_SMS_LIST = "/sms/queryPage";

//权限管理
export const URL_AUTH_LIST = "/authExt/queryPage";
export const URL_AUTH_TREE = "/authExt/goTree";
export const URL_AUTH_UPDATE = "/authExt/doUpdate";

//字典管理
export const URL_DICT_TREE = "/dictExt/getDictTree";
export const URL_DICT_LIST = "/dictExt/queryPage";
export const URL_DICT_LISTITEM = "/dictExt/getDictItemById";
export const URL_DICT_SAVE = "/dictExt/doSave";
export const URL_DICT_DELETE = "/dictExt/doDelete";
export const URL_DICT_UPDATE = "/dictExt/doUpdate";
export const URL_DICTITEM_SAVE = "/dictItemExt/doSave";
export const URL_DICTITEM_CHANGESTATE = "/dictItemExt/doChangeState";
export const URL_DICTITEM_UPDATE = "/dictItemExt/doUpdate";
export const URL_DICTITEM_DELETE = "/dictItemExt/doDelete";

//** 用户管理
export const URL_USER_LIST = "/userExt/queryPage";
export const URL_DEPT_TREE = "/deptExt/goTree";
export const URL_USER_VIEW = "/userExt/goView"
export const URL_USER_DELETE = "/deptExt/doDelete";

//** 组织管理
export const URL_DEPT_LIST = "/deptExt/queryPage";
export const URL_DEPT_DETAIL = "/deptExt/goNFUpdate";
export const URL_DEPT_UPDATE = "/deptExt/doUpdate";
// 新增
export const URL_DEPT_SAVE = "/deptExt/doSave";
// 根据父部门id获取父部门名称
export const URL_DEPT_DEPT_NAME = "/deptExt/getParentDeptName";

//** 日志管理
export const URL_LOG_LIST = "/logExt/queryPage";
export const URL_LOG_DETAIL = "/logExt/goNFView";
export const URL_LOG_OPER_USER_TREE = "/logExt/getOperUserTree";

//**角色管理
export const URL_ROLE_LIST = "/roleExt/queryPage";
export const URL_ROLE_DETAIL = "/roleExt/goNFUpdate";
export const URL_ROLE_SAVE = "/roleExt/doSave";
export const URL_ROLE_UPDATE = "/roleExt/doUpdate";
export const URL_ROLE_CHANGESTATE = "/roleExt/doChangeState";
export const URL_ROLE_DELETE = "/roleExt/doDelete";
//获取角色权限
export const URL_ROLE_ROLEAUTH = "/roleExt/goSetRoleAuth";
//赋予权限
export const URL_ROLE_SETROLEAUTH = "/roleExt/doSetRoleAuth";
//用户管理
export const URL_USER_CHANGESTATE = "/userExt/doChangeState";
export const URL_USER_PASS_REST = "/userExt/doRestPassword";
export const URL_USER_UPDATE = "/userExt/doUpdate";
export const URL_USER_DETAIL = "/userExt/goNFUpdate";
export const URL_USER_SAVE = "/userExt/doSave";
//修改密码
export const URL_USER_CHANGE_PASS = "/userExt/doChangePassword";
export const URL_USER_ROLES = "/userExt/goNFSetUserRole";
export const URL_USER_SET_ROLES = "/userExt/doSetUserRole";

//** 菜单管理
export const URL_MENU_LIST = "/menuExt/queryPage";
export const URL_MENU_TREE = "/menuExt/goTree";
export const URL_MENU_DELETE = "/menuExt/doDelete";
export const URL_MENU_DETAIL = "/menuExt/goNFUpdate";
export const URL_MENU_UPDATE = "/menuExt/doUpdate";
export const URL_MENU_GET_MENU_NAME = "/menuExt/getMenuName";
export const URL_MENU_GET_NEXT_ORDER = "/menuExt/getNextOrder";
// 新增
export const URL_MENU_SAVE = "/menuExt/doSave";


//获取个人菜单列表
export const URL_GET_MENU = "/getMenu";


export function api(url, param) {
  return new Promise((resolve, reject) => {
    axios({
      url,
      method: "post",
      data: param
    }).then(response => {
      let data = response.data;
      // 返回正确，直接抛出数据 data.data
      if (data.rs) {
        resolve(data.datas);
      } else {
        message.error(data.msg);
        reject();
      }
    });
  });
}

export function fetchDeptName(url, param) {
  return new Promise((resolve, reject) => {
    axios({
      url,
      method: "post",
      data: param
    }).then(response => {
      let data = response.data;
      // 返回正确，直接抛出数据 data.data
      if (data.rs) {
        resolve(data.msg);
      } else {
        message.error(data.msg);
        reject();
      }
    });
  });
}