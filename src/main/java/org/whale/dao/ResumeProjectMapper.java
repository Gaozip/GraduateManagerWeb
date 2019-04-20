package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.ResumeProject;

/**
* @ClassName： ResumeProjectMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
public interface ResumeProjectMapper {

	void doSave(ResumeProject project);

	List<ResumeProject> getResumeProjectByResumeId(Long pkResumeId);

	void doUpdateByResumeId(List<ResumeProject> projectList);

	void doDeleteByResumeId(@Param("resumeId")Long resumeId);

	List<Long> getResumeProjectIdByResumeId(Long pkResumeId);

	List<ResumeProject> queryPageByFkId(@Param("fkResumeId")Long fkResumeId);

	void doDelete(@Param("id")Long id);

	void doUpdate(ResumeProject project);

	ResumeProject getResumeProjectByPkId(@Param("pkResumeProject")Long pkResumeProject);

}

