package org.whale.pojo;

/**
 * @ClassName： DictItem 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年4月20日
 */
public class DictItem {

	private Long pkDictItemId;

    private String itemName;

    private String itemCode;

    private String itemVal;

    private String dictType;

    private String remark;

    private Short isValid;

    private Long fkDictId;

    public Long getPkDictItemId() {
        return pkDictItemId;
    }

    public void setPkDictItemId(Long pkDictItemId) {
        this.pkDictItemId = pkDictItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemVal() {
        return itemVal;
    }

    public void setItemVal(String itemVal) {
        this.itemVal = itemVal == null ? null : itemVal.trim();
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
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

    public Long getFkDictId() {
        return fkDictId;
    }

    public void setFkDictId(Long fkDictId) {
        this.fkDictId = fkDictId;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DictItem [pkDictItemId=");
		builder.append(pkDictItemId);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemVal=");
		builder.append(itemVal);
		builder.append(", dictType=");
		builder.append(dictType);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", fkDictId=");
		builder.append(fkDictId);
		builder.append("]");
		return builder.toString();
	}
}