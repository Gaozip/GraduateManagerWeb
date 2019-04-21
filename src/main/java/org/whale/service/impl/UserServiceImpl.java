package org.whale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.whale.constant.Constant;
import org.whale.dao.EmployerInfoMapper;
import org.whale.dao.GraduateInfoMapper;
import org.whale.dao.UserMapper;
import org.whale.pojo.EmployerInfo;
import org.whale.pojo.GraduateInfo;
import org.whale.pojo.User;
import org.whale.service.UserService;

/**
* @ClassName： UserServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月9日
*/
@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private GraduateInfoMapper graduateInfoMapper;
	
	@Autowired
	private EmployerInfoMapper employerInfoMapper;
	
	@Override
	public int IsRegister(String userName, String email) {
		return userMapper.IsRegister(userName,email);
	}
	
	
	@Override
	public void addUser(User user) throws Exception {
		userMapper.addUser(user);
		GraduateInfo graduateInfo = new GraduateInfo();
		graduateInfo.setFkUserId(user.getPkUserId());
		graduateInfo.setEmail(user.getEmail());
		
		EmployerInfo employerInfo = new EmployerInfo();
		employerInfo.setFkUserId(user.getPkUserId());
		employerInfo.setEmail(user.getEmail());
		
		if(user.getRole() == Constant.USER_GRADUATE){
			graduateInfoMapper.addLine(graduateInfo);
		}else if(user.getRole() == Constant.USER_EMPLOYEE){
			employerInfoMapper.addLine(employerInfo);
		}
	}

	@Override
	public User doLogin(User user) {
		return userMapper.doLogin(user);
	}

	@Override
	public String getCode(String userName) {
		return userMapper.getCode(userName);
	}

	@Override
	public void updateState(String userName) {
		userMapper.updateState(userName);
	}

	@Override
	public void changeUserName(String userName , Long pkUserId) {
		User user = new User();
		user.setUsername(userName);
		user.setPkUserId(pkUserId);
		userMapper.changeUserName(user);
	}

	@Override
	public void changePassword(String password, Long pkUserId) {
		User user = new User();
		user.setPassword(password);
		user.setPkUserId(pkUserId);
		userMapper.changePassword(user);
	}

	@Override
	public void uploadUserHeadImage(Long pkUserId, String path) {
		userMapper.uploadUserHeadImage(pkUserId,path);
	}

	@Override
	public String getUserHeadPath(Long pkUserId) {
		return this.userMapper.getUserHeadPath(pkUserId);
	}


	@Override
	public String haveUserHeadPath(Long userId) {
		return this.userMapper.haveUserHeadPath(userId);
	}


	@Override
	public void doRegisterAdminUser(User user) {
		
		this.userMapper.doRegisterAdminUser(user);
	}

}

