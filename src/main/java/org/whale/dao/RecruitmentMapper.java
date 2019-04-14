package org.whale.dao;

import java.util.List;

import org.whale.pojo.Recruitment;

/**
* @ClassName： RecruitmentMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月26日
*/
public interface RecruitmentMapper {

	void doSave(Recruitment recruitment);

	List<Recruitment> queryPage(Long userId);

	void doUpdate(Recruitment recruitment);

	void doDelete(Long pkRecruitmentId);

}

