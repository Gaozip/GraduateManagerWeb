package org.whale.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： Resume
 * @Description：简历实体
 * @author： 皮卡尔稽 
 * @date：2019年2月20日
 */
public class Resume {
	private Long pkResumeId;

    private String professionalAbility;

    private String certificate;

    private String jobType;

    private String expertIndustry;

    private String expertJobIntension;

    private String province;

    private String city;

    private Long expertSalary;

    private String jobStatus;

    private Short isValid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Long fkUserId;
    
    private List<ResumeWork> workList;
    
    private List<ResumeProject> projectList;
    
    private GraduateInfo graduateInfo;

    public List<ResumeWork> getWorkList() {
		return workList;
	}

	public void setWorkList(List<ResumeWork> workList) {
		this.workList = workList;
	}

	public List<ResumeProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ResumeProject> projectList) {
		this.projectList = projectList;
	}

	public GraduateInfo getGraduateInfo() {
		return graduateInfo;
	}

	public void setGraduateInfo(GraduateInfo graduateInfo) {
		this.graduateInfo = graduateInfo;
	}

	public Long getPkResumeId() {
        return pkResumeId;
    }

    public void setPkResumeId(Long pkResumeId) {
        this.pkResumeId = pkResumeId;
    }

    public String getProfessionalAbility() {
        return professionalAbility;
    }

    public void setProfessionalAbility(String professionalAbility) {
        this.professionalAbility = professionalAbility == null ? null : professionalAbility.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    public String getExpertIndustry() {
        return expertIndustry;
    }

    public void setExpertIndustry(String expertIndustry) {
        this.expertIndustry = expertIndustry == null ? null : expertIndustry.trim();
    }

    public String getExpertJobIntension() {
        return expertJobIntension;
    }

    public void setExpertJobIntension(String expertJobIntension) {
        this.expertJobIntension = expertJobIntension == null ? null : expertJobIntension.trim();
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

    public Long getExpertSalary() {
        return expertSalary;
    }

    public void setExpertSalary(Long expertSalary) {
        this.expertSalary = expertSalary;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    public Short getIsValid() {
        return isValid;
    }

    public void setIsValid(Short isValid) {
        this.isValid = isValid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
		builder.append("Resume [pkResumeId=");
		builder.append(pkResumeId);
		builder.append(", professionalAbility=");
		builder.append(professionalAbility);
		builder.append(", certificate=");
		builder.append(certificate);
		builder.append(", jobType=");
		builder.append(jobType);
		builder.append(", expertIndustry=");
		builder.append(expertIndustry);
		builder.append(", expertJobIntension=");
		builder.append(expertJobIntension);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", expertSalary=");
		builder.append(expertSalary);
		builder.append(", jobStatus=");
		builder.append(jobStatus);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", fkUserId=");
		builder.append(fkUserId);
		builder.append("]");
		return builder.toString();
	}
    
}