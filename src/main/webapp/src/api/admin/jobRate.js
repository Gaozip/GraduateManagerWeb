import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_QUERY_JOB_RATE = '/admin/queryJobRate'
export const URL_QUERY_STUDENT_INFO = '/admin/queryStudentInfo'

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