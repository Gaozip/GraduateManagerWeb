package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： User
 * @Description：用户实体
 * @author： 皮卡尔稽 
 * @date：2019年1月23日
 */
public class User {

	private Long pkUserId;

	private String username;

	private String password;

	private Short role;

	private Short state;

	private String code;

	private String headPath;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date activeTime;

	private String email;

	private Short isValid;

	public Long getPkUserId() {
		return pkUserId;
	}

	public void setPkUserId(Long pkUserId) {
		this.pkUserId = pkUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getHeadPath() {
		return headPath;
	}

	public void setHeadPath(String headPath) {
		this.headPath = headPath == null ? null : headPath.trim();
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Short getIsValid() {
		return isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [pkUserId=");
		builder.append(pkUserId);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role=");
		builder.append(role);
		builder.append(", state=");
		builder.append(state);
		builder.append(", code=");
		builder.append(code);
		builder.append(", headPath=");
		builder.append(headPath);
		builder.append(", registerTime=");
		builder.append(registerTime);
		builder.append(", activeTime=");
		builder.append(activeTime);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append("]");
		return builder.toString();
	}
	
}