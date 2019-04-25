package org.whale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whale.pojo.GerInfo;
import org.whale.pojo.Page;
import org.whale.service.GerInfoService;
import org.whale.utils.WebUtils;

/**
* @ClassName： GerInfoController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月24日
*/
@Controller
@RequestMapping("/gerInfo")
public class GerInfoController extends BaseController{

	@Autowired
	private GerInfoService gerInfoService;
	
	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,GerInfo gerInfo){
		
		try {
			int num = this.gerInfoService.ifExist(gerInfo);
			if(num != 0){
				WebUtils.printFail(request, response, "重复投递简历!");
			}else{
				gerInfo.setFkGraduateId(this.getUserId(request));
				this.gerInfoService.doSave(gerInfo);
				WebUtils.printSuccess(request, response);
			}
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据保存失败!");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/doUpdate")
	public void doUpdate(HttpServletRequest request,HttpServletResponse response,@RequestParam("pkGerId")Long pkGerId){
		
		try {
			this.gerInfoService.doUpdate(pkGerId);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据更新失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询本公司收到的简历
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryReceivedResume")
	public void queryReceivedResume(HttpServletRequest request,HttpServletResponse response){
		
		try {
			Page page2 = this.newPage(request);
			Map<String, String> paramMap = this.getParamMap(request);
			Long userId = this.getUserId(request);
			Page page = this.gerInfoService.queryReceivedResume(page2,paramMap,userId);
			WebUtils.printSuccess(request, response,page);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询本用户创建的所有招聘信息的id和招聘职位
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryRecruitmentIdList")
	public void queryRecruitmentIdList(HttpServletRequest request,HttpServletResponse response){
		
		try {
			Long pkUserId = this.getUserId(request);
			List<HashMap<String, Object>> idList = this.gerInfoService.queryRecruitmentIdList(pkUserId);
			WebUtils.printSuccess(request, response, idList);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/queryResultPage")
	public void queryResultPage(HttpServletRequest request,HttpServletResponse response){
		try {
			Long userId = this.getUserId(request);
			Page page2 = this.newPage(request);
			Map<String, String> paramMap = this.getParamMap(request);
			Page page = this.gerInfoService.queryResultPage(page2,paramMap,userId);
			WebUtils.printSuccess(request, response, page);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
}

