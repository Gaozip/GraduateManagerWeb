package org.whale.pojo;

/**
 * @ClassName： ResumeProject 
 * @Description：
 * @author： 皮卡尔稽 
 * @date：2019年2月20日
 */
public class ResumeProject {
	
	private Long pkResumeProject;

    private String projectName;

    private String projectDescription;

    private String personalResponsibility;

    private String companyName;

    private String projectDate;

    private Long fkResumeId;

    public Long getPkResumeProject() {
        return pkResumeProject;
    }

    public void setPkResumeProject(Long pkResumeProject) {
        this.pkResumeProject = pkResumeProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public String getPersonalResponsibility() {
        return personalResponsibility;
    }

    public void setPersonalResponsibility(String personalResponsibility) {
        this.personalResponsibility = personalResponsibility == null ? null : personalResponsibility.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate == null ? null : projectDate.trim();
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
		builder.append("ResumeProject [pkResumeProject=");
		builder.append(pkResumeProject);
		builder.append(", projectName=");
		builder.append(projectName);
		builder.append(", projectDescription=");
		builder.append(projectDescription);
		builder.append(", personalResponsibility=");
		builder.append(personalResponsibility);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", projectDate=");
		builder.append(projectDate);
		builder.append(", fkResumeId=");
		builder.append(fkResumeId);
		builder.append("]");
		return builder.toString();
	}
    
}