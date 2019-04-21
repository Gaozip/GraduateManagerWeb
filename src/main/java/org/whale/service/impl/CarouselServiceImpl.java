package org.whale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.CarouselMapper;
import org.whale.pojo.Carousel;
import org.whale.service.CarouselService;

/**
* @ClassName： CarouselServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月21日
*/
@Service
public class CarouselServiceImpl implements CarouselService {

	@Autowired
	private CarouselMapper carouselMapper;
	
	@Override
	public List<Carousel> queryPictureList() {
		
		return this.carouselMapper.queryPictureList();
	}

	@Override
	public void doSave(String fileName, String imgPath) {
		 
		this.carouselMapper.doSave(fileName,imgPath);
	}

	@Override
	public void doDeleteByImgName(String fileName) {
		
		this.carouselMapper.doDeleteByImgName(fileName);
	}

}

