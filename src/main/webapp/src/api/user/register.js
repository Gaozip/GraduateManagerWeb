import { Message as message } from 'element-ui';
import axios from '../../axios/index.js';

export const URL_USER_IS_REGISTER = '/user/IsRegister'  //判断用户名、邮箱是否已被注册
export const UEL_USER_OD_SAVE = '/user/doSave'; //注册用户

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
