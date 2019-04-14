package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： EmployerInfo 
 * @Description：
 * @author： 皮卡尔稽 
 * @date：2019年2月24日
 */
public class EmployerInfo {

	private Long pkEmployerId;

    private String companyName;

    private String organizationCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;

    private Long registerCapital;

    private String companyType;

    private String industry;

    private Long employerNum;

    private Long hotLine;

    private String province;

    private String city;

    private String email;

    private String companyAddress;

    private String companyProfile;

    private String legalRepresentative;

    private String managementForms;

    private String scopeOfBusiness;

    private Short isValid;

    private Long fkUserId;

    public Long getPkEmployerId() {
        return pkEmployerId;
    }

    public void setPkEmployerId(Long pkEmployerId) {
        this.pkEmployerId = pkEmployerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Long getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Long registerCapital) {
        this.registerCapital = registerCapital;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Long getEmployerNum() {
        return employerNum;
    }

    public void setEmployerNum(Long employerNum) {
        this.employerNum = employerNum;
    }

    public Long getHotLine() {
        return hotLine;
    }

    public void setHotLine(Long hotLine) {
        this.hotLine = hotLine;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile == null ? null : companyProfile.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getManagementForms() {
        return managementForms;
    }

    public void setManagementForms(String managementForms) {
        this.managementForms = managementForms == null ? null : managementForms.trim();
    }

    public String getScopeOfBusiness() {
        return scopeOfBusiness;
    }

    public void setScopeOfBusiness(String scopeOfBusiness) {
        this.scopeOfBusiness = scopeOfBusiness == null ? null : scopeOfBusiness.trim();
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
		StringBuilder builder = new StringBuilder();
		builder.append("EmployerInfo [pkEmployerId=");
		builder.append(pkEmployerId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", organizationCode=");
		builder.append(organizationCode);
		builder.append(", registerDate=");
		builder.append(registerDate);
		builder.append(", registerCapital=");
		builder.append(registerCapital);
		builder.append(", companyType=");
		builder.append(companyType);
		builder.append(", industry=");
		builder.append(industry);
		builder.append(", employerNum=");
		builder.append(employerNum);
		builder.append(", hotLine=");
		builder.append(hotLine);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", email=");
		builder.append(email);
		builder.append(", companyAddress=");
		builder.append(companyAddress);
		builder.append(", companyProfile=");
		builder.append(companyProfile);
		builder.append(", legalRepresentative=");
		builder.append(legalRepresentative);
		builder.append(", managementForms=");
		builder.append(managementForms);
		builder.append(", scopeOfBusiness=");
		builder.append(scopeOfBusiness);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", fkUserId=");
		builder.append(fkUserId);
		builder.append("]");
		return builder.toString();
	}
    
}