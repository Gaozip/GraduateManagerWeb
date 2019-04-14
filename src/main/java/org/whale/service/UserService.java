package org.whale.service;

import org.whale.pojo.User;

/**
* @ClassName： UserService
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月9日
*/
public interface UserService {

	void addUser(User user) throws Exception;

	User doLogin(User user);

	String getCode(String userName);

	void updateState(String userName);

	void changeUserName(String userName , Long pkUserId);

	void changePassword(String password, Long pkUserId);

	void uploadUserHeadImage(Long pkUserId, String string);

	String getUserHeadPath(Long pkUserId);

	int IsRegister(String userName, String email);

	String haveUserHeadPath(Long userId);

}

