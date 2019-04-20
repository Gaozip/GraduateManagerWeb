package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.Recruitment;

/**
* @ClassName： RecruitmentMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月26日
*/
public interface RecruitmentMapper {

	void doSave(Recruitment recruitment);

	List<Recruitment> queryPage(@Param("userId")Long userId, @Param("pkRecruitmentId")String pkRecruitmentId);

	void doUpdate(Recruitment recruitment);

	void doDelete(Long pkRecruitmentId);

	Recruitment getRecruitmentByPkId(@Param("pkRecruitmentId")Long pkRecruitmentId);

}

