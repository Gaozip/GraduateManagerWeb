package org.whale.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName： Article 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年2月23日
 */
public class Article {

	private Long pkArticleId;

    private String articleItem;

    private Short articleType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    private Short isValid;

    private Short isTop;

    private String articleBody;

    public Long getPkArticleId() {
        return pkArticleId;
    }

    public void setPkArticleId(Long pkArticleId) {
        this.pkArticleId = pkArticleId;
    }

    public String getArticleItem() {
        return articleItem;
    }

    public void setArticleItem(String articleItem) {
        this.articleItem = articleItem == null ? null : articleItem.trim();
    }

    public Short getArticleType() {
        return articleType;
    }

    public void setArticleType(Short articleType) {
        this.articleType = articleType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Short getIsValid() {
        return isValid;
    }

    public void setIsValid(Short isValid) {
        this.isValid = isValid;
    }

    public Short getIsTop() {
        return isTop;
    }

    public void setIsTop(Short isTop) {
        this.isTop = isTop;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody == null ? null : articleBody.trim();
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [pkArticleId=");
		builder.append(pkArticleId);
		builder.append(", articleItem=");
		builder.append(articleItem);
		builder.append(", articleType=");
		builder.append(articleType);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", isTop=");
		builder.append(isTop);
		builder.append(", articleBody=");
		builder.append(articleBody);
		builder.append("]");
		return builder.toString();
	}
    
}