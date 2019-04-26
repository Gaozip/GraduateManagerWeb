package org.whale.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.whale.pojo.GerInfo;
import org.whale.pojo.Page;

/**
* @ClassName： GerInfoService
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月24日
*/
public interface GerInfoService {

	void doSave(GerInfo gerInfo);

	void doUpdate(Long pkGerId);

	int ifExist(GerInfo gerInfo);

	List<HashMap<String, Object>> queryRecruitmentIdList(Long pkUserId);

	Page queryReceivedResume(Page page2, Map<String, String> paramMap, Long userId);

	Page queryResultPage(Page page2, Map<String, String> paramMap, Long userId);

	Long getGraduateId(Long userId);

}

