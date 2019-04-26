package org.whale.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.GerInfo;
import org.whale.pojo.Recruitment;

/**
* @ClassName： RecruitmentMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月26日
*/
public interface RecruitmentMapper {

	void doSave(Recruitment recruitment);

	List<Recruitment> queryPage(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("userId")Long userId, @Param("pkRecruitmentId")String pkRecruitmentId);
	
	int queryTotalNum(@Param("userId")Long userId, @Param("pkRecruitmentId")String pkRecruitmentId);

	void doUpdate(Recruitment recruitment);

	void doDelete(Long pkRecruitmentId);

	Recruitment getRecruitmentByPkId(@Param("pkRecruitmentId")Long pkRecruitmentId);

	List<Recruitment> doSearchRecruitment(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("position")String position,
			@Param("monthSalary")String monthSalary, @Param("province")String province, @Param("city")String city, @Param("jobNature")String jobNature, @Param("education")String education, @Param("workExperience")String workExperience,
			@Param("fUZZY_WORD")String fUZZY_WORD);
	
	int getTotalNum(@Param("position")String position,
			@Param("monthSalary")String monthSalary, @Param("province")String province, @Param("city")String city, @Param("jobNature")String jobNature, @Param("education")String education, @Param("workExperience")String workExperience,
			@Param("fUZZY_WORD")String fUZZY_WORD);

	List<HashMap<String, Object>> queryRecruitmentIdList(@Param("pkUserId")Long pkUserId);

	List<GerInfo> queryReceivedResume(@Param("fkResumeId")String fkResumeId, @Param("fkRecruitmentId")String fkRecruitmentId);
}

