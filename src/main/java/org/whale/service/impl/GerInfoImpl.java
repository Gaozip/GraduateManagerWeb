package org.whale.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.EmployerInfoMapper;
import org.whale.dao.GerInfoMapper;
import org.whale.dao.GraduateInfoMapper;
import org.whale.dao.RecruitmentMapper;
import org.whale.dao.ResumeMapper;
import org.whale.dao.ResumeProjectMapper;
import org.whale.dao.ResumeWorkMapper;
import org.whale.pojo.EmployerInfo;
import org.whale.pojo.GerInfo;
import org.whale.pojo.Page;
import org.whale.pojo.Recruitment;
import org.whale.pojo.Resume;
import org.whale.service.GerInfoService;

/**
* @ClassName： GerInfoImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月24日
*/
@Service
public class GerInfoImpl implements GerInfoService {

	@Autowired
	private GerInfoMapper gerInfoMapper;
	
	@Autowired
	private RecruitmentMapper recruitmentMapper;
	
	@Autowired
	private ResumeMapper resumeMapper;
	
	@Autowired
	private ResumeWorkMapper resumeWorkMapper;
	
	@Autowired
	private ResumeProjectMapper resumeProjectMapper;
	
	@Autowired
	private GraduateInfoMapper graduateInfoMapper;
	
	@Autowired
	private EmployerInfoMapper employerInfoMapper;
	
	@Override
	public void doSave(GerInfo gerInfo) {
		
		this.gerInfoMapper.doSave(gerInfo);
	}

	@Override
	public void doUpdate(Long pkGerId) {
		
		this.gerInfoMapper.doUpdate(pkGerId);
	}

	@Override
	public int ifExist(GerInfo gerInfo) {
		
		return this.gerInfoMapper.ifExist(gerInfo);
	}

	@Override
	public List<HashMap<String, Object>> queryRecruitmentIdList(Long pkUserId) {

		return this.recruitmentMapper.queryRecruitmentIdList(pkUserId);
	}

	@Override
	public Page queryReceivedResume(Page page2, Map<String, String> paramMap,Long userId) {
		
		String fkResumeId = paramMap.get("fkResumeId");
		String fkRecruitmentId = paramMap.get("fkRecruitmentId");
		
		List<GerInfo> gerInfosList = this.gerInfoMapper.queryReceivedResume(page2.getLimitA(),page2.getLimitB(),fkResumeId,fkRecruitmentId,userId);
		for(GerInfo gerInfo : gerInfosList){
			Long resumeId = gerInfo.getFkResumeId();
			Long recruitmentId = gerInfo.getFkRecruitmentId();
			Resume resume = this.resumeMapper.queryResumeById(resumeId);
			resume.setWorkList(this.resumeWorkMapper.queryPageByFkId(resume.getPkResumeId()));
		    resume.setProjectList(this.resumeProjectMapper.queryPageByFkId(resume.getPkResumeId()));
		    resume.setGraduateInfo(this.graduateInfoMapper.queryBasicInfoById(userId));
		    gerInfo.setResume(resume);
		    Recruitment recruitment = this.recruitmentMapper.getRecruitmentByPkId(recruitmentId);
		    EmployerInfo employerInfo = this.employerInfoMapper.getEmployerInfoByUserId(recruitment.getFkUserId());
		    recruitment.setEmployerInfo(employerInfo);
		    gerInfo.setRecruitment(recruitment);
		}
		int num = this.gerInfoMapper.getTotalNum(fkResumeId,fkRecruitmentId,userId);
		page2.setTotalNum((long)num);
		page2.setDatas(gerInfosList);
		return page2;
				
	}

	@Override
	public Page queryResultPage(Page page2, Map<String, String> paramMap, Long userId) {
		
		List<GerInfo> list = this.gerInfoMapper.queryResultPage(page2.getLimitA(),page2.getLimitB(),userId);
		for(GerInfo gerInfo : list){
			Long resumeId = gerInfo.getFkResumeId();
			Long recruitmentId = gerInfo.getFkRecruitmentId();
			Resume resume = this.resumeMapper.queryResumeById(resumeId);
			resume.setWorkList(this.resumeWorkMapper.queryPageByFkId(resume.getPkResumeId()));
		    resume.setProjectList(this.resumeProjectMapper.queryPageByFkId(resume.getPkResumeId()));
		    resume.setGraduateInfo(this.graduateInfoMapper.queryBasicInfoById(userId));
		    gerInfo.setResume(resume);
		    Recruitment recruitment = this.recruitmentMapper.getRecruitmentByPkId(recruitmentId);
		    EmployerInfo employerInfo = this.employerInfoMapper.getEmployerInfoByUserId(recruitment.getFkUserId());
		    recruitment.setEmployerInfo(employerInfo);
		    gerInfo.setRecruitment(recruitment);
		}
		page2.setTotalNum((long)list.size());
		page2.setDatas(list);
		return page2;
	}

}

