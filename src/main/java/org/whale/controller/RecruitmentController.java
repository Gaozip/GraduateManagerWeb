package org.whale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whale.pojo.Page;
import org.whale.pojo.Recruitment;
import org.whale.pojo.User;
import org.whale.service.RecruitmentService;
import org.whale.utils.WebUtils;

/**
* @ClassName： RecruitmentController
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月27日
*/
@Controller
@RequestMapping("/recruitment")
public class RecruitmentController extends BaseController{

	@Autowired
	private RecruitmentService recruitmentService;
	
	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,Recruitment recruitment){
		Long userId = ((User)request.getSession().getAttribute("user")).getPkUserId();
		recruitment.setState((short)1);
		recruitment.setFkUserId(userId);
		recruitmentService.doSave(recruitment);
		WebUtils.printSuccess(request, response);
	}
	
	@RequestMapping("/queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response){
		Page page = this.newPage(request);
		Long userId = ((User)request.getSession().getAttribute("user")).getPkUserId();
		Page pages = recruitmentService.queryPage(page,userId);
		WebUtils.printSuccess(request, response, pages);
	}
	
	@RequestMapping("/doUpdate")
	public void doUpdate(HttpServletRequest request,HttpServletResponse response,Recruitment recruitment){
		try {
			recruitmentService.doUpdate(recruitment);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.printFail(request, response, "更新失败");
		}
	}
	
	@RequestMapping("/doDelete")
	public void doDelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("pkRecruitmentId") Long pkRecruitmentId){
		try {
			recruitmentService.doDelete(pkRecruitmentId);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.printFail(request, response, "删除失败");
		}
	}
}
