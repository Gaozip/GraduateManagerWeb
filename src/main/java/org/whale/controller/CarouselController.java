package org.whale.controller;
/**
* @ClassName： CarouselController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月19日
*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.whale.pojo.Carousel;

@RequestMapping("/carousel")
public class CarouselController {

	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,Carousel carousel){

	} 
}

