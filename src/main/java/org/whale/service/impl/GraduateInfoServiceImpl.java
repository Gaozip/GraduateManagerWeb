package org.whale.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.GraduateInfoMapper;
import org.whale.pojo.GraduateInfo;
import org.whale.pojo.Page;
import org.whale.service.GraduateInfoService;
import org.whale.utils.StringUtils;

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

		StringBuilder sql = new StringBuilder("select * from SYS_EMPLOYER_INFO t where 1 = 1 ");
		
		if(paramMap != null && paramMap.size() > 0){
			String COMPANY_NAME = paramMap.get("COMPANY_NAME");
			if(StringUtils.isNotBlank(COMPANY_NAME)){
				sql.append("and t.COMPANY_NAME like %"+COMPANY_NAME.trim()+"% ");
			}
			String ORGANIZATION_CODE = paramMap.get("ORGANIZATION_CODE");
			if(StringUtils.isNotBlank(ORGANIZATION_CODE)){
				sql.append("and t.ORGANIZATION_CODE like %"+ORGANIZATION_CODE.trim()+"% ");
			}
			String LEGAL_REPRESENTATIVE = paramMap.get("LEGAL_REPRESENTATIVE");
			if(StringUtils.isNotBlank(LEGAL_REPRESENTATIVE)){
				sql.append("and t.LEGAL_REPRESENTATIVE like %"+LEGAL_REPRESENTATIVE.trim()+"% ");
			}
			String COMPANY_TYPE = paramMap.get("COMPANY_TYPE");
			if(StringUtils.isNotBlank(COMPANY_TYPE)){
				sql.append("and t.COMPANY_TYPE like %"+COMPANY_TYPE.trim()+"% ");
			}
			String INDUSTRY = paramMap.get("INDUSTRY");
			if(StringUtils.isNotBlank(INDUSTRY)){
				sql.append("and t.INDUSTRY like %"+INDUSTRY.trim()+"% ");
			}
			String EMPLOYER_NUM = paramMap.get("EMPLOYER_NUM");
			if(StringUtils.isNotBlank(EMPLOYER_NUM)){
				sql.append("and t.EMPLOYER_NUM >= "+EMPLOYER_NUM.trim()+" ");
			}
			String REGISTER_CAPITAL = paramMap.get("REGISTER_CAPITAL");
			if(StringUtils.isNotBlank(REGISTER_CAPITAL)){
				sql.append("and t.REGISTER_CAPITAL >= "+REGISTER_CAPITAL.trim()+" ");
			}
			String BEGIN_REGISTER_DATE = paramMap.get("BEGIN_REGISTER_DATE");
			if(StringUtils.isNotBlank(BEGIN_REGISTER_DATE)){
				sql.append("and t.REGISTER_DATE >= to_date("+BEGIN_REGISTER_DATE.trim()+",'yyyy-mm-dd hh24:mi:ss') ");
			}
			String END_REGISTER_DATE = paramMap.get("END_REGISTER_DATE");
			if(StringUtils.isNotBlank(END_REGISTER_DATE)){
				sql.append("and t.REGISTER_DATE <= to_date("+END_REGISTER_DATE.trim()+",'yyyy-mm-dd hh24:mi:ss') ");
			}
			
			String FUZZY_WORD = paramMap.get("FUZZY_WORD");
			if(StringUtils.isNotBlank(FUZZY_WORD)){
				sql.append("and "
							+ "(t.COMPANY_NAME like %"+FUZZY_WORD.trim()+"% or "
							+ "t.ORGANIZATION_CODE like %"+FUZZY_WORD.trim()+"% or"
							+ "t.LEGAL_REPRESENTATIVE like %"+FUZZY_WORD.trim()+"% or"
							+ "t.COMPANY_TYPE like %"+FUZZY_WORD.trim()+"% or"
							+ "t.INDUSTRY like %"+FUZZY_WORD.trim()+"% )"
				);
			}
		}
		page.setSql(sql.toString());
//		return pageUtils.queryPage(page);
		return null;
	}

	

}

