import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_QUERY_HOT_LINE_INFO = '/admin/queryAdminHotLineInfo'   //查询服务热线信息
export const URL_QUERY_PICTURE_LIST = '/carousel/queryPictureList'  //查询走马灯图片列表
export const URL_DELETE_PICTURE = '/carousel/doDelete' //删除走马灯图片

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