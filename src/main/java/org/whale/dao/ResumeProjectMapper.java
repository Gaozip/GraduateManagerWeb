package org.whale.dao;

import java.util.List;

import org.whale.pojo.ResumeProject;

/**
* @ClassName： ResumeProjectMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
public interface ResumeProjectMapper {

	int doSave(List<ResumeProject> projectList);

	List<ResumeProject> getResumeProjectByResumeId(Long pkResumeId);

	void doUpdateByResumeId(List<ResumeProject> projectList);

	void doDeleteByResumeId(Long resumeId);

}

