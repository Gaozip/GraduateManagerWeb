import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_ARTICLE_SAVE = '/article/doSave'  //保存公告
export const URL_ARTICLE_SHOW = '/article/queryPage' //查询公告列表
export const URL_DO_UPDATE = '/article/doUpdate' //更新公告信息
export const URL_DO_DELETE = '/article/doDelete' 

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