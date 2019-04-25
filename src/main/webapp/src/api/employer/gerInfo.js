import { Message as message } from 'element-ui';
import axios from '../../axios/index.js';
export const URL_DO_SAVE = '/gerInfo/doSave'; //投递简历
export const URL_QUERY_RECRUITMENT_LIST = '/gerInfo/queryRecruitmentIdList';
export const URL_QUERY_RESUME_RECEIVE = '/gerInfo/queryReceivedResume';
export const URL_DO_UPDATE = '/gerInfo/doUpdate'   //确认简历是否通过
export const URL_QUERY_RESULT_PAGE = '/gerInfo/queryResultPage' //查询简历投递结果 

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