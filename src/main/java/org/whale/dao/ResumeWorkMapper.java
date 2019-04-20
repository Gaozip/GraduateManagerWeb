package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.ResumeWork;

/**
* @ClassName： ResumeWorkMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
public interface ResumeWorkMapper {

	void doSave(ResumeWork work);

	List<ResumeWork> getResumeWorkByResumeId(Long resumeId);

	void doUpdate(ResumeWork work);

	List<Long> getResumeWorkIdByResumeId(Long pkResumeId);

	void doDelete(Long pkResumeWorkId);

	List<ResumeWork> queryPageByFkId(@Param("fkResumeId")Long fkResumeId);

	ResumeWork getResumeWorkByPkId(@Param("pkResumeWorkId")Long pkResumeWorkId);

	void doDeleteByResumeId(@Param("fkResumeId")Long resumeId);

}

