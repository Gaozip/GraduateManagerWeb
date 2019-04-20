import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_DO_SAVE_HOT_LINE_INFO = '/admin/doSaveHotLineInfo'  //保存服务热线信息
export const URL_QUERY_HOT_LINE_INFO = '/admin/queryAdminHotLineInfo'   //查询服务热线信息

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