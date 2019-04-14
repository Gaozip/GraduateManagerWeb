/*
 * @Author: Book
 * @Date:   2018-06-13 17:37:22
 * @Last Modified by:   Book
 * @Last Modified time: 2018-10-15 10:27:28
 */

import moment from 'moment';

/**
 * tree 数据转换成 element 支持的类型
 */
export function transformTreeData(data) {
  let tree = [];
  // 确定根节点，初始化属性
  for (let i = 0; i < data.length; i++) {
    data[i].children = []; // 初始化 children 属性
    if (data[i].pid == undefined) { //加载一级节点
      tree.push(data[i]);
    }
  }
  // console.info(tree);
  for (var i = 0; i < data.length; i++) {
    for (var j = 0; j < data.length; j++) {
      if (data[i].pid == data[j].id) {
        data[j].children.push(data[i]);
        break;
      }
    }
  }
  return tree; //返回tree
}

/**
 * 时区转换需要使用 moment 过滤一次
 */
export function transformTime(param, fmt) {
  if (fmt) {
    return new moment(param).format(fmt);
  }
  return new moment(param).format();
}

/**
 * 为一个 element 的时间选择器对象设置日期
 *
 * @param {[type]} options.date    必填，需要设置的日期
 * @param {String} options.dateFmt 可填，设置的日期的格式，默认是 YYYY-MM-DD
 * @param {[type]} options.time    必填，时间对象
 * @param {[type]} options.fmt     可填，最终的输出格式
 */
export function setTimeWithDate({date, dateFmt = 'YYYY-MM-DD', time, fmt}) {
  if (!time || time === '') {
    return '';
  }
  let rs = moment(time);
  if (date) {
    let dateMt = moment(date, dateFmt);
    rs.year(dateMt.year());
    rs.month(dateMt.month());
    rs.date(dateMt.date());
  }
  if (fmt) {
    return rs.format(fmt);
  }
  return rs.format();
}


/**
 * 数据库字段全大写转驼峰例如FFF_YYY-->fffYyy
 */
export function camelCase(string) {
  string = string.toLowerCase();
  return string.replace(/_([a-z])/g, function(all, letter) {
    return letter.toUpperCase();
  });
}

/**
 * 生成uuid(随机数)
 */
export function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("");
    return uuid;
}

/**
 * JS获取地址栏参数
 * @param  {String} name 参数的名称
 * @return {String}
 */
export function getUrlParam(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var r = window.location.search.substr(1).match(reg); //匹配目标参数
  if (r != null) return unescape(r[2]);
  return null; //返回参数值
}