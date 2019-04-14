package org.whale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.RecruitmentMapper;
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
	
	@Override
	public void doSave(Recruitment recruitment) {
		
		recruitmentMapper.doSave(recruitment);
	}

	@Override
	public Page queryPage(Page page, Long userId) {
		List<Recruitment> recruitmentList = recruitmentMapper.queryPage(userId);
		page.setTotalNum((long)recruitmentList.size());
		page.setDatas(recruitmentList);
		return page;
	}

	@Override
	public void doUpdate(Recruitment recruitment) {
		recruitmentMapper.doUpdate(recruitment);
	}

	@Override
	public void doDelete(Long pkRecruitmentId) {
		recruitmentMapper.doDelete(pkRecruitmentId);
	}

	
}

