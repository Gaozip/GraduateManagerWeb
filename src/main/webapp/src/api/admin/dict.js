import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_DO_SAVE = '/dict/doSave'  
export const URL_DO_UPDATE = '/dict/doUpdate'  
export const URL_QUERY_PAGE = '/dict/queryPage'
export const URL_DO_DELETE = '/dict/doDelete'

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