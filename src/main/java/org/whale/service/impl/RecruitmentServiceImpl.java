package org.whale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.EmployerInfoMapper;
import org.whale.dao.RecruitmentMapper;
import org.whale.dao.ResumeMapper;
import org.whale.pojo.EmployerInfo;
import org.whale.pojo.Page;
import org.whale.pojo.Recruitment;
import org.whale.service.RecruitmentService;

/**
* @ClassName： RecruitmentServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月27日
*/
@Service
public class RecruitmentServiceImpl implements RecruitmentService{

	@Autowired
	private RecruitmentMapper recruitmentMapper;
	
	@Autowired
	private EmployerInfoMapper employerInfoMapper;
	
	@Autowired
	private ResumeMapper resumeMapper;
	
	@Override
	public void doSave(Recruitment recruitment) {
		
		recruitmentMapper.doSave(recruitment);
	}

	@Override
	public Page queryPage(Page page,Map<String, String> paramMap,Long userId) {
		
		String pkRecruitmentId = paramMap.get("pkRecruitmentId");
		List<Recruitment> recruitmentList = recruitmentMapper.queryPage(page.getLimitA(),page.getLimitB(),userId,pkRecruitmentId);
		
		if(recruitmentList.size() != 0){
			for(Recruitment recruitment : recruitmentList){
				EmployerInfo employerInfo = this.employerInfoMapper.getEmployerInfoByUserId(recruitment.getFkUserId());
				recruitment.setEmployerInfo(employerInfo);
			}
		}
		int totalNum = this.recruitmentMapper.queryTotalNum(userId, pkRecruitmentId);
		page.setTotalNum((long)totalNum);
		page.setDatas(recruitmentList);
		return page;
	}

	@Override
	public void doUpdate(Recruitment recruitment2) {
		Recruitment recruitment = this.recruitmentMapper.getRecruitmentByPkId(recruitment2.getPkRecruitmentId());
		recruitment.setPosition(recruitment2.getPosition());
		recruitment.setMonthSalary(recruitment2.getMonthSalary());
		recruitment.setProvince(recruitment2.getProvince());
		recruitment.setCity(recruitment2.getCity());
		recruitment.setJobNature(recruitment2.getJobNature());
		recruitment.setRecruitNum(recruitment2.getRecruitNum());
		recruitment.setEducation(recruitment2.getEducation());
		recruitment.setWorkExperience(recruitment2.getWorkExperience());
		recruitment.setJobContent(recruitment2.getJobContent());
		recruitment.setQualification(recruitment2.getQualification());
		recruitment.setState(recruitment2.getState());
		recruitmentMapper.doUpdate(recruitment);
	}

	@Override
	public void doDelete(Long pkRecruitmentId) {
		recruitmentMapper.doDelete(pkRecruitmentId);
	}

	@Override
	public List<Integer> queryAllResumeIdByUserId(Long userId) {
		 List<Integer> list = this.resumeMapper.queryAllResumeIdByUserId(userId);
		 return list;
	}

	
}

