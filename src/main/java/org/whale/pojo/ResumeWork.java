package org.whale.pojo;

/**
 * @ClassName： ResumeWork 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年2月20日
 */
public class ResumeWork {

	private Long pkResumeWorkId;

	private String companyName;

	private String industry;

	private String jobIntension;

	private String jobType;

	private Long monthSalary;

	private String jobDescription;

	private String workDate;

	private Short isValid;

	private Long fkResumeId;

	public Long getPkResumeWorkId() {
		return pkResumeWorkId;
	}

	public void setPkResumeWorkId(Long pkResumeWorkId) {
		this.pkResumeWorkId = pkResumeWorkId;
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

	public String getJobIntension() {
		return jobIntension;
	}

	public void setJobIntension(String jobIntension) {
		this.jobIntension = jobIntension == null ? null : jobIntension.trim();
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType == null ? null : jobType.trim();
	}

	public Long getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(Long monthSalary) {
		this.monthSalary = monthSalary;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription == null ? null : jobDescription.trim();
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate == null ? null : workDate.trim();
	}

	public Short getIsValid() {
		return isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

	public Long getFkResumeId() {
		return fkResumeId;
	}

	public void setFkResumeId(Long fkResumeId) {
		this.fkResumeId = fkResumeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResumeWork [pkResumeWorkId=");
		builder.append(pkResumeWorkId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", industry=");
		builder.append(industry);
		builder.append(", jobIntension=");
		builder.append(jobIntension);
		builder.append(", jobType=");
		builder.append(jobType);
		builder.append(", monthSalary=");
		builder.append(monthSalary);
		builder.append(", jobDescription=");
		builder.append(jobDescription);
		builder.append(", workDate=");
		builder.append(workDate);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", fkResumeId=");
		builder.append(fkResumeId);
		builder.append("]");
		return builder.toString();
	}
}