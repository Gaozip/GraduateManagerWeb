package org.whale.dao;

import java.util.List;

import org.whale.pojo.ResumeWork;

/**
* @ClassName： ResumeWorkMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
public interface ResumeWorkMapper {

	int doSave(List<ResumeWork> workList);

	List<ResumeWork> getResumeWorkByResumeId(Long resumeId);

	void doUpdateByResumeId(List<ResumeWork> workList);

	void doDeleteByResumeId(Long resumeId);

}

