package org.whale.controller;
/**
* @ClassName： CarouselController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月19日
*/

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.whale.common.AuthLogin;
import org.whale.pojo.Carousel;
import org.whale.service.CarouselService;
import org.whale.utils.WebUtils;

@Controller
@RequestMapping("/carousel")
public class CarouselController {
	
	@Autowired
	private CarouselService carouselService;
	
	@AuthLogin
	@RequestMapping("/queryPictureList")
	public void queryPictureList(HttpServletRequest request,HttpServletResponse response){
		
		try {
			List<Carousel> carouselList = this.carouselService.queryPictureList();
			WebUtils.printSuccess(request, response, carouselList);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
	

	@AuthLogin
	@RequestMapping(value="/doSave",method=RequestMethod.POST)
	public void doSave(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		
		//图片存放路径
		String path = "/UserImages/carousel/";
		
		if(!file.isEmpty()) {
        	//设置图片名称
        	String fileName = file.getOriginalFilename();
        	
			file.transferTo(new File(path+fileName));
			
			//将图片信息存入数据库
			this.carouselService.doSave(fileName,"/upload/carousel/"+fileName);
			
        }else{
        	WebUtils.printFail(request, response, "请选择上传图片");
        }
	} 
	
	@AuthLogin
	@RequestMapping("/doDelete")
	public void doDelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("fileName")String fileName){
		
		try {
			//先删除本地图片
			new File("/UserImages/carousel/"+fileName).delete();
			
			//再删除数据库内图片信息
			this.carouselService.doDeleteByImgName(fileName);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据删除失败!");
			e.printStackTrace();
		}
	}
}

