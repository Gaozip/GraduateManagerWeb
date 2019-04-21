import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_QUERY_USER_PAGE = '/admin/queryUserPage'  
export const URL_DO_UPDATE_USER_STATE = '/admin/doUpdateUserState'

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