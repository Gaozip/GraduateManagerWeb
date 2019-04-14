import { Message as message } from 'element-ui';
import axios from '../../axios/index.js';

export const URL_DO_LOGIN = '/user/doLogin';//登录

export const URL_USER_NAME = '/user/getUserName'  //获取用户名
export const URL_ARTICLE_SHOW = '/article/queryPage' //查询公告列表



export function api(url, param) {
    return new Promise((resolve, reject) => {
        axios({
            url,
            method: "post",
            data: param
        }).then(response => {
            let data = response.data;
            // 返回正确，直接抛出数据 data.data
            if(!data.rs){
                message.error(data.msg);
                reject();
            }
            resolve(data);
        });
    });
}

export function loginOut(param) {
    return new Promise((resolve, reject) => {
        axios({
            url: '/user/loginOut', // 服务地址
            method: 'post',
            data: param,
        }).then(response => {
            let data = response.data;
            console.info(data);
            // if(data.rs) {
                resolve(data.data)
            // } else {
            //     if(data.msg) {
            //         message.error(data.msg);
            //     } else {
            //         message.error("注销失败!");
            //     }
            //     reject()
            // }
        });
    })
}