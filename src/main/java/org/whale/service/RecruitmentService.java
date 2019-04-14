package org.whale.service;

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

	Page queryPage(Page page, Long userId);

	void doUpdate(Recruitment recruitment);

	void doDelete(Long pkRecruitmentId);

}

