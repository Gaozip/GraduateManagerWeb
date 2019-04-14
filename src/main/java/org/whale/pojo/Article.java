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

    private Short isHop;

    private String articleDoby;

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

    public Short getIsHop() {
        return isHop;
    }

    public void setIsHop(Short isHop) {
        this.isHop = isHop;
    }

    public String getArticleDoby() {
        return articleDoby;
    }

    public void setArticleDoby(String articleDoby) {
        this.articleDoby = articleDoby == null ? null : articleDoby.trim();
    }

	@Override
	public String toString() {
		return "Article [pkArticleId=" + pkArticleId + ", articleItem=" + articleItem + ", articleType=" + articleType
				+ ", startTime=" + startTime + ", isValid=" + isValid + ", isHop=" + isHop + ", articleDoby="
				+ articleDoby + "]";
	}
    
}