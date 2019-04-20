package org.whale.pojo;
/**
* @ClassName： Dict
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
public class Dict {
	
	private Long pkDictId;

    private String dictName;

    private String dictCode;

    private String remark;

    private Short isValid;

    public Long getPkDictId() {
        return pkDictId;
    }

    public void setPkDictId(Long pkDictId) {
        this.pkDictId = pkDictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
		builder.append("Dict [pkDictId=");
		builder.append(pkDictId);
		builder.append(", dictName=");
		builder.append(dictName);
		builder.append(", dictCode=");
		builder.append(dictCode);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append("]");
		return builder.toString();
	}
    
}