import { Message as message } from 'element-ui';
import axios from '../../axios/index.js';

export const URL_QUERY_COMPANY_INFO = '/graduate/doSearchCompanyInfo'    //查询用户基本信息
export const URL_QUERY_RECRUITMENT_INFO = '/graduate/doSearchRecruitment';  //查询简历信息

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