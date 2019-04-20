package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： Recruitment 
 * @Description：
 * @author： 皮卡尔稽 
 * @date：2019年2月26日
 */
public class Recruitment {

    private Long pkRecruitmentId;

    private String position;

    private Long monthSalary;

    private String jobNature;

    private String province;

    private String city;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postedDate;

    private Short state;

    private Long recruitNum;

    private String jobContent;

    private String qualification;

    private String education;

    private String workExperience;

    private Long fkUserId;
    
    private EmployerInfo employerInfo;
    
    

    public EmployerInfo getEmployerInfo() {
		return employerInfo;
	}

	public void setEmployerInfo(EmployerInfo employerInfo) {
		this.employerInfo = employerInfo;
	}

	public Long getPkRecruitmentId() {
        return pkRecruitmentId;
    }

    public void setPkRecruitmentId(Long pkRecruitmentId) {
        this.pkRecruitmentId = pkRecruitmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Long getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(Long monthSalary) {
        this.monthSalary = monthSalary;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature == null ? null : jobNature.trim();
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

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Long getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(Long recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent == null ? null : jobContent.trim();
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification == null ? null : qualification.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience == null ? null : workExperience.trim();
    }

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recruitment [pkRecruitmentId=");
		builder.append(pkRecruitmentId);
		builder.append(", position=");
		builder.append(position);
		builder.append(", monthSalary=");
		builder.append(monthSalary);
		builder.append(", jobNature=");
		builder.append(jobNature);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", postedDate=");
		builder.append(postedDate);
		builder.append(", state=");
		builder.append(state);
		builder.append(", recruitNum=");
		builder.append(recruitNum);
		builder.append(", jobContent=");
		builder.append(jobContent);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append(", education=");
		builder.append(education);
		builder.append(", workExperience=");
		builder.append(workExperience);
		builder.append(", fkUserId=");
		builder.append(fkUserId);
		builder.append("]");
		return builder.toString();
	}
}