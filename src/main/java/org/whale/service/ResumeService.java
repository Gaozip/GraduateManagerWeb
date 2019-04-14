package org.whale.service;

import java.util.List;

import org.whale.pojo.Page;
import org.whale.pojo.Resume;
import org.whale.pojo.ResumeProject;
import org.whale.pojo.ResumeWork;

/**
* @ClassName： ResumeService
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
public interface ResumeService {

	void doSave(Resume resume,List<ResumeWork> workList,List<ResumeProject> projectList);

	Page queryResumePage(Page page, Long userId);

	void doUpdateByResumeId(Long resumeId, Resume resume, List<ResumeWork> workList, List<ResumeProject> projectList);

	void doDeleteByResumeId(Long resumeId);

	Page doSearch(Page page, Long resumeId);

	Page getResumeByEmployer(Page page);

	Page doSearchByRequire(Page page, Long resumeId, String expertIndustry, String education, String sex, Long age,
			String workYear, String gradCollege, String expertJobIntension,Long userId);

	
}

