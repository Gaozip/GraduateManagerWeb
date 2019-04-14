package org.whale.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.whale.pojo.Resume;

/**
* @ClassName： ResumeMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
public interface ResumeMapper {

	int doSave(Resume resume);

	Long getResumeId(Resume resume);

	List<Resume> getResumeByUserId(Resume resume);

	void doUpdateByResumeId(Resume resume);

	void doDeleteByResumeId(Long resumeId);

	List<Resume> getResumeByResumeId(Long resumeId);

	List<Resume> getResumeByEmployer();

	List<Resume> doSearchByRequire(@Param("resumeId")Long resumeId, @Param("expertIndustry")String expertIndustry, @Param("education")String education, @Param("sex")String sex, @Param("age")Long age,
			@Param("workYear")String workYear, @Param("gradCollege")String gradCollege, @Param("expertJobIntension")String expertJobIntension,@Param("userId")Long userId);

}
