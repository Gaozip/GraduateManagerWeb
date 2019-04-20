import { Message as message } from 'element-ui';
import axios from '../../axios/index.js';
export const URL_GET_EMPLOYER_INFO_BY_ID = '/employer/getEmployerInfoByUserId'; 
export const URL_DO_UPDATE = '/employer/doUpdate';    
export const URL_GET_RESUME_BY_EMPLOYER = '/resume/getResumeByEmployer';

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