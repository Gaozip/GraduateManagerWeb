package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： Recruitment 
 * @Description：
 *  @author： 皮卡尔稽 
 *  @date：2019年2月26日
 */
public class Recruitment {

	private Long pkRecruitmentId;

    private String position;

    private Long monthSalary;

    private String workPlace;

    private String jobNature;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postedDate;

    private Short state;

    private Long recruitNum;

    private String jobContent;

    private String qualification;

    private String education;

    private String workExperience;

    private Long fkUserId;

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

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature == null ? null : jobNature.trim();
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
		return "Recruitment [pkRecruitmentId=" + pkRecruitmentId + ", position=" + position + ", monthSalary="
				+ monthSalary + ", workPlace=" + workPlace + ", jobNature=" + jobNature + ", postedDate=" + postedDate
				+ ", state=" + state + ", recruitNum=" + recruitNum + ", jobContent=" + jobContent + ", qualification="
				+ qualification + ", education=" + education + ", workExperience=" + workExperience + ", fkUserId="
				+ fkUserId + "]";
	}
    
}