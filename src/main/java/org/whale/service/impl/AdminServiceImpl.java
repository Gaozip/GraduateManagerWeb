package org.whale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.GraduateInfoMapper;
import org.whale.dao.UserMapper;
import org.whale.pojo.GraduateInfo;
import org.whale.pojo.Page;
import org.whale.pojo.User;
import org.whale.service.AdminService;

/**
* @ClassName： AdminServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月21日
*/
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private GraduateInfoMapper graduateInfoMapper;
	
	@Override
	public Page queryUserPage(Page page2, Map<String, String> paramMap) {

		String username = paramMap.get("username");
		String email = paramMap.get("email");
		String role = paramMap.get("role");
		String state = paramMap.get("state");
		String isValid = paramMap.get("isValid");
		String registerStartTime = paramMap.get("registerStartTime");
		String registerEndTime = paramMap.get("registerEndTime");
		String activeStartTime = paramMap.get("activeStartTime");
		String activeEndTime = paramMap.get("activeEndTime");
		String FUZZY_WORD = paramMap.get("FUZZY_WORD");
		
		List<User> userList = this.userMapper.queryUserPage(page2.getLimitA(),page2.getLimitB(),username,email,role,state,isValid,registerStartTime,registerEndTime,activeStartTime,activeEndTime,FUZZY_WORD);
		int num = this.userMapper.getTotalNum(username,email,role,state,isValid,registerStartTime,registerEndTime,activeStartTime,activeEndTime,FUZZY_WORD);
		page2.setTotalNum((long)num);
		page2.setDatas(userList);
		return page2;
	}

	@Override
	public void doUpdateUserState(Map<String, String> paramMap) {

		String state = paramMap.get("state");
		String isValid = paramMap.get("isValid");
		String pkUserId = paramMap.get("pkUserId");
		this.userMapper.doUpdateUserState(state,isValid,pkUserId);
	}

	@Override
	public Map<String, Double> queryJobRate(Map<String, String> paramMap) {

		String grade = paramMap.get("grade");
		String dept = paramMap.get("dept");
		String specialty = paramMap.get("specialty");
		
		return this.userMapper.queryJobRate(grade,dept,specialty);
	}

	@Override
	public Page queryStudentInfo(Page page, Map<String, String> paramMap) {

		String grade = paramMap.get("grade");
		String dept = paramMap.get("dept");
		String specialty = paramMap.get("specialty");
		
		List<GraduateInfo> list = graduateInfoMapper.queryStudentInfo(page.getLimitA(),page.getLimitB(),grade,dept,specialty);
		int num = this.graduateInfoMapper.queryTotalNum(grade,dept,specialty);
		page.setTotalNum((long)num);
		page.setDatas(list);
		return page;
	}

}

