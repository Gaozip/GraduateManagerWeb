package org.whale.service;

import java.util.Map;

import org.whale.pojo.GraduateInfo;
import org.whale.pojo.Page;

/**
* @ClassName： GraduateService
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月24日
*/
public interface GraduateInfoService {

	void doUpdate(GraduateInfo graduateInfo);

	void doUpdateJobInfoByUserId(GraduateInfo graduateInfo);

	GraduateInfo queryBasicInfoById(Long userId);

	Page doSearchCompanyInfo(Page page, Map<String, String> paramMap);

}

