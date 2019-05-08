package org.whale.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.whale.common.AuthLogin;
import org.whale.pojo.Page;
import org.whale.service.AdminService;
import org.whale.utils.DictUtils;
import org.whale.utils.WebUtils;

/**
* @ClassName： AdminController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月19日
*/
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{
	
	@Resource
	private DictUtils dictUtils;
	
	@Autowired
	private AdminService adminService;
	
	@AuthLogin
	@RequestMapping("/queryAdminHotLineInfo")
	public void queryAdminHotLineInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			Map<String, String> map = new HashMap<String,String>();
			map.put("customerServiceTel", dictUtils.getDictItemByItemCode("CUSTOMER_SERVICE_TEL"));
			map.put("mobilePhone", dictUtils.getDictItemByItemCode("MOBILE_PHONE"));
			map.put("telephone", dictUtils.getDictItemByItemCode("TELEPHONE"));
			map.put("serviceEmail", dictUtils.getDictItemByItemCode("SERVICE_EMAIL"));
			map.put("serviceAddress", dictUtils.getDictItemByItemCode("SERVICE_ADDRESS"));
			WebUtils.printSuccess(request, response, map);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "字典数据获取失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/queryUserPage")
	public void queryUserPage(HttpServletRequest request,HttpServletResponse response){
		try {
			Page page2 = this.newPage(request);
			Map<String, String> paramMap = this.getParamMap(request);
			Page page = this.adminService.queryUserPage(page2,paramMap);
			WebUtils.printSuccess(request, response, page);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doUpdateUserState")
	public void doUpdateUserState(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, String> paramMap = this.getParamMap(request);
		try {
			this.adminService.doUpdateUserState(paramMap);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据更改失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/queryJobRate")
	public void queryJobRate(HttpServletRequest request,HttpServletResponse response){
		
		try {
			Map<String, String> paramMap = this.getParamMap(request);
			
			Map<String,Double> jobRateMap = this.adminService.queryJobRate(paramMap);
			WebUtils.printSuccess(request, response, jobRateMap);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/queryStudentInfo")
	public void queryStudentInfo(HttpServletRequest request,HttpServletResponse response){
		
		try {
			Map<String, String> paramMap = this.getParamMap(request);
			Page page2 = this.newPage(request);
			Page page = this.adminService.queryStudentInfo(page2,paramMap);
			WebUtils.printSuccess(request, response, page);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
}

