package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： GraduateInfo 
 * @Description： 
 * @author： 皮卡尔稽
 * @date：2019年2月24日
 */
public class GraduateInfo {
	
	private Long pkGradId;

	private Long sno;

	private String name;

	private String sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String nation;

	private String province;

	private String city;

	private String politicalStatus;

	private Long tel;

	private Long qq;

	private String wchat;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inDate;

	private String dept;

	private String specialty;

	private String education;

	private String graduateCollege;

	private Short haveJob;

	private String companyName;

	private String industry;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date getJobTime;

	private Long monthSalary;

	private String position;

	private String workYear;

	private String email;

	private Short isValid;

	private Long fkUserId;

	public Long getPkGradId() {
		return pkGradId;
	}

	public void setPkGradId(Long pkGradId) {
		this.pkGradId = pkGradId;
	}

	public Long getSno() {
		return sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus == null ? null : politicalStatus.trim();
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public Long getQq() {
		return qq;
	}

	public void setQq(Long qq) {
		this.qq = qq;
	}

	public String getWchat() {
		return wchat;
	}

	public void setWchat(String wchat) {
		this.wchat = wchat == null ? null : wchat.trim();
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept == null ? null : dept.trim();
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty == null ? null : specialty.trim();
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}

	public String getGraduateCollege() {
		return graduateCollege;
	}

	public void setGraduateCollege(String graduateCollege) {
		this.graduateCollege = graduateCollege == null ? null : graduateCollege.trim();
	}

	public Short getHaveJob() {
		return haveJob;
	}

	public void setHaveJob(Short haveJob) {
		this.haveJob = haveJob;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry == null ? null : industry.trim();
	}

	public Date getGetJobTime() {
		return getJobTime;
	}

	public void setGetJobTime(Date getJobTime) {
		this.getJobTime = getJobTime;
	}

	public Long getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(Long monthSalary) {
		this.monthSalary = monthSalary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear == null ? null : workYear.trim();
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

	public Long getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(Long fkUserId) {
		this.fkUserId = fkUserId;
	}

	@Override
	public String toString() {
		return "GraduateInfo [pkGradId=" + pkGradId + ", sno=" + sno + ", name=" + name + ", sex=" + sex + ", birthday="
				+ birthday + ", nation=" + nation + ", province=" + province + ", city=" + city + ", politicalStatus="
				+ politicalStatus + ", tel=" + tel + ", qq=" + qq + ", wchat=" + wchat + ", inDate=" + inDate
				+ ", dept=" + dept + ", specialty=" + specialty + ", education=" + education + ", graduateCollege="
				+ graduateCollege + ", haveJob=" + haveJob + ", companyName=" + companyName + ", industry=" + industry
				+ ", getJobTime=" + getJobTime + ", monthSalary=" + monthSalary + ", position=" + position
				+ ", workYear=" + workYear + ", email=" + email + ", isValid=" + isValid + ", fkUserId=" + fkUserId
				+ "]";
	}
}