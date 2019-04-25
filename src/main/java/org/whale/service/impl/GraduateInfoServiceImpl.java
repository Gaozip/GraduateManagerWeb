package org.whale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.EmployerInfoMapper;
import org.whale.dao.GraduateInfoMapper;
import org.whale.dao.RecruitmentMapper;
import org.whale.pojo.EmployerInfo;
import org.whale.pojo.GraduateInfo;
import org.whale.pojo.Page;
import org.whale.pojo.Recruitment;
import org.whale.service.GraduateInfoService;

/**
* @ClassName： GraduateServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月24日
*/
@Service
public class GraduateInfoServiceImpl implements GraduateInfoService {

	@Autowired
	private GraduateInfoMapper graduateInfoMapper;
	
	@Autowired
	private EmployerInfoMapper employerInfoMapper;
	
	@Autowired
	private RecruitmentMapper recruitmentMapper;
	
	@Override
	public GraduateInfo queryBasicInfoById(Long userId) {
		return graduateInfoMapper.queryBasicInfoById(userId);
	}
	
	@Override
	public void doUpdate(GraduateInfo graduateInfo) {
		graduateInfoMapper.doUpdate(graduateInfo);
		
	}

	@Override
	public void doUpdateJobInfoByUserId(GraduateInfo graduateInfo) {
		graduateInfoMapper.doUpdate(graduateInfo);
	}

	@Override
	public Page doSearchCompanyInfo(Page page, Map<String, String> paramMap) {

		String companyName = paramMap.get("companyName");
		String organizationCode = paramMap.get("organizationCode");
		String legalRepresentative = paramMap.get("legalRepresentative");
		String companyType = paramMap.get("companyType");
		String industry = paramMap.get("industry");
		String employerNum = paramMap.get("employerNum");
		String registerCapital = paramMap.get("registerCapital");
		String beginRegisterDate = paramMap.get("beginRegisterDate");
		String endRegisterDate = paramMap.get("endRegisterDate");
		String FUZZY_WORD = paramMap.get("FUZZY_WORD");
		List<EmployerInfo> list = this.employerInfoMapper.doSearchCompanyInfo(page.getLimitA(),page.getLimitB(),companyName,organizationCode,legalRepresentative,companyType,industry,employerNum,registerCapital,beginRegisterDate,endRegisterDate,FUZZY_WORD);
		int num = this.employerInfoMapper.getTotalNum(companyName,organizationCode,legalRepresentative,companyType,industry,employerNum,registerCapital,beginRegisterDate,endRegisterDate,FUZZY_WORD);
		page.setTotalNum((long)num);
		page.setDatas(list);
		return page;
	}

	@Override
	public Page doSearchRecruitment(Page page2, Map<String, String> paramMap) {
//		String companyName = paramMap.get("companyName");
		String position = paramMap.get("position");
		String monthSalary = paramMap.get("monthSalary");
		String province = paramMap.get("province");
		String city = paramMap.get("city");
		String jobNature = paramMap.get("jobNature");
		String education = paramMap.get("education");
		String workExperience = paramMap.get("workExperience");
		String FUZZY_WORD = paramMap.get("FUZZY_WORD");
		List<Recruitment> list = this.recruitmentMapper.doSearchRecruitment(page2.getLimitA(),page2.getLimitB(),position,monthSalary,province,city,jobNature,education,workExperience,FUZZY_WORD);
		
		
		for(Recruitment recruitment : list){
			Long fkUserId = recruitment.getFkUserId();
			EmployerInfo employerInfo = this.employerInfoMapper.getEmployerInfoByUserId(fkUserId);
			recruitment.setEmployerInfo(employerInfo);
		}
		
		int totalNum = this.recruitmentMapper.getTotalNum(position, monthSalary, province, city, jobNature, education, workExperience, FUZZY_WORD);
		page2.setTotalNum((long)totalNum);
		page2.setDatas(list);
		return page2;
	}
}

