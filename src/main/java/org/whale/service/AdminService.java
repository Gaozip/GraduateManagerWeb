package org.whale.service;

import java.util.Map;

import org.whale.pojo.Page;

/**
* @ClassName： AdminService
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月21日
*/
public interface AdminService {

	Page queryUserPage(Page page2, Map<String, String> paramMap);

	void doUpdateUserState(Map<String, String> paramMap);

	Map<String, Double> queryJobRate(Map<String, String> paramMap);

	Page queryStudentInfo(Page page2, Map<String, String> paramMap);

}

