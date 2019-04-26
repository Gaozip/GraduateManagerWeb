package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.GerInfo;

/**
* @ClassName： GerInfoMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月24日
*/
public interface GerInfoMapper {

	void doSave(GerInfo gerInfo);

	void doUpdate(@Param("pkGerId")Long pkGerId);

	int ifExist(GerInfo gerInfo);

	List<GerInfo> queryReceivedResume(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("fkResumeId")String fkResumeId, @Param("fkRecruitmentId")String fkRecruitmentId, @Param("employerId")Long userId);

	int getTotalNum(@Param("fkResumeId")String fkResumeId, @Param("fkRecruitmentId")String fkRecruitmentId, @Param("employerId")Long userId);

	List<GerInfo> queryResultPage(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("userId")Long userId);

	int queryTotalNum(@Param("userId")Long userId);

}

