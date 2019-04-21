package org.whale.dao;

import java.util.List;
import java.util.Map;

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

	List<User> queryUserPage(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("username")String username, @Param("email")String email, @Param("role")String role, @Param("state")String state,
			@Param("isValid")String isValid, @Param("registerStartTime")String registerStartTime, @Param("registerEndTime")String registerEndTime, @Param("activeStartTime")String activeStartTime,
			@Param("activeEndTime")String activeEndTime,@Param("FUZZY_WORD")String FUZZY_WORD);

	int getTotalNum(@Param("username")String username, @Param("email")String email, @Param("role")String role, @Param("state")String state,
			@Param("isValid")String isValid, @Param("registerStartTime")String registerStartTime, @Param("registerEndTime")String registerEndTime, @Param("activeStartTime")String activeStartTime,
			@Param("activeEndTime")String activeEndTime,@Param("FUZZY_WORD")String FUZZY_WORD);

	void doUpdateUserState(@Param("state")String state, @Param("isValid")String isValid, @Param("pkUserId")String pkUserId);

	void doRegisterAdminUser(User user);

	Map<String, Double> queryJobRate(@Param("grade")String grade, @Param("dept")String dept, @Param("specialty")String specialty);

}

