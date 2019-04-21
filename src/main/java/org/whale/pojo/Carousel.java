package org.whale.pojo;
/**
* @ClassName： Carousel
* @Description：走马灯实体
* @author： 皮卡尔稽
* @date：2019年4月19日
*/
public class Carousel {
	
	private Long pkCarouselId;

    private String imgPath;

    private String fileName;

    public Long getPkCarouselId() {
        return pkCarouselId;
    }

    public void setPkCarouselId(Long pkCarouselId) {
        this.pkCarouselId = pkCarouselId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carousel [pkCarouselId=");
		builder.append(pkCarouselId);
		builder.append(", imgPath=");
		builder.append(imgPath);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append("]");
		return builder.toString();
	}
    
}