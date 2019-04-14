package org.whale.dao;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.User;

/**
* @ClassName： UserMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月1日
*/
public interface UserMapper {
	
	int IsRegister(@Param("userName")String userName, @Param("email")String email);
	
	int addUser(User user);
	
	int IsRegisterByEmail(User user);
	
	int IsRegisterByUserName(User user);
	
	User doLogin(User user);

	String getCode(String userName);

	void updateState(String userName);

	void changeUserName(User user);

	void changePassword(User user);

	String getUserHeadPath(Long pkUserId);

	void uploadUserHeadImage(@Param("arg0")Long pkUserId, @Param("arg1")String path);

	String haveUserHeadPath(@Param("userId")Long userId);

}

