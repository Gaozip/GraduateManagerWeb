package org.whale.service;

import java.util.List;

import org.whale.pojo.Carousel;

/**
* @ClassName： CarouselService
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月21日
*/
public interface CarouselService {

	List<Carousel> queryPictureList();

	void doSave(String fileName, String string);

	void doDeleteByImgName(String fileName);

}

