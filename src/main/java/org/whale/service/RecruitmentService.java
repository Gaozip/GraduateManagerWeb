package org.whale.service;

import java.util.List;
import java.util.Map;

import org.whale.pojo.Page;
import org.whale.pojo.Recruitment;

/**
* @ClassName： RecruitmentService
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月27日
*/
public interface RecruitmentService {

	void doSave(Recruitment recruitment);

	Page queryPage(Page page, Map<String, String> paramMap, Long userId);

	void doUpdate(Recruitment recruitment);

	void doDelete(Long pkRecruitmentId);

	List<Long> queryAllResumeIdByUserId(Long userId);

}

