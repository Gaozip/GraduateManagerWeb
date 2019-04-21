package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.Carousel;

/**
* @ClassName： CarouselMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月19日
*/
public interface CarouselMapper {
	
	void doSave(Carousel carousel);
	
	void doUpdate(Carousel carousel);
	
	List<Carousel> queryPage();

	List<Carousel> queryPictureList();

	void doSave(@Param("fileName")String fileName, @Param("imgPath")String imgPath);

	void doDeleteByImgName(@Param("fileName")String fileName);
}

