package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： GerInfo 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年4月24日
 */
public class GerInfo {

	private Long pkGerId;

	private Long fkResumeId;

	private Long fkRecruitmentId;

	private Long fkEmployerId;

	private Long fkGraduateId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sendTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date resultTime;

	private Short result;
	
	private Resume resume;
	
	private Recruitment recruitment;

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public Long getPkGerId() {
		return pkGerId;
	}

	public void setPkGerId(Long pkGerId) {
		this.pkGerId = pkGerId;
	}

	public Long getFkResumeId() {
		return fkResumeId;
	}

	public void setFkResumeId(Long fkResumeId) {
		this.fkResumeId = fkResumeId;
	}

	public Long getFkRecruitmentId() {
		return fkRecruitmentId;
	}

	public void setFkRecruitmentId(Long fkRecruitmentId) {
		this.fkRecruitmentId = fkRecruitmentId;
	}

	public Long getFkEmployerId() {
		return fkEmployerId;
	}

	public void setFkEmployerId(Long fkEmployerId) {
		this.fkEmployerId = fkEmployerId;
	}

	public Long getFkGraduateId() {
		return fkGraduateId;
	}

	public void setFkGraduateId(Long fkGraduateId) {
		this.fkGraduateId = fkGraduateId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getResultTime() {
		return resultTime;
	}

	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
	}

	public Short getResult() {
		return result;
	}

	public void setResult(Short result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GerInfo [pkGerId=");
		builder.append(pkGerId);
		builder.append(", fkResumeId=");
		builder.append(fkResumeId);
		builder.append(", fkRecruitmentId=");
		builder.append(fkRecruitmentId);
		builder.append(", fkEmployerId=");
		builder.append(fkEmployerId);
		builder.append(", fkGraduateId=");
		builder.append(fkGraduateId);
		builder.append(", sendTime=");
		builder.append(sendTime);
		builder.append(", resultTime=");
		builder.append(resultTime);
		builder.append(", result=");
		builder.append(result);
		builder.append("]");
		return builder.toString();
	}
}