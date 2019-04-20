import { Message as message } from 'element-ui';
import axios from '../../axios/index.js';

export const URL_DO_SEARCH = '/resume/doSearch'   
export const URL_QUERY_PAGE = '/resume/queryPage'
export const URL_DO_SAVE = '/resume/doSave'   
export const URL_DO_UPDATE = '/resume/doUpdate'   
export const URL_DO_DELETE = '/resume/doDelete'


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