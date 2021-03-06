import axios from '../../axios/index.js';
import { Message as message } from 'element-ui';

export const URL_DO_SAVE = '/recruitment/doSave';
export const URL_QUERY_PAGE = '/recruitment/queryPage';
export const URL_DO_UPDATE = '/recruitment/doUpdate';
export const URL_DO_DELETE = '/recruitment/doDelete';
export const URL_QUERY_ALL_RESUME_ID_BY_USER_ID = '/recruitment/queryAllResumeIdByUserId';  //查询此人所有的简历id

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