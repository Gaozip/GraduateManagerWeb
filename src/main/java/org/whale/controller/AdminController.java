package org.whale.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @ClassName： AdminController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月19日
*/
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{
	
	@RequestMapping("/doSaveHotLineInfo")
	public void doSaveHotLineInfo(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException{
		
	}
	
	@RequestMapping("/queryAdminHotLineInfo")
	public void queryAdminHotLineInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
	
}

