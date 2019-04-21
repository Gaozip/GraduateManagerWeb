package org.whale.controller;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.whale.pojo.GraduateInfo;
import org.whale.pojo.Page;
import org.whale.service.GraduateInfoService;
import org.whale.utils.WebUtils;

/**
* @ClassName： GraduateController
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月24日
*/
@Controller
@RequestMapping("/graduate")
public class GraduateController extends BaseController{

	@Autowired
	private GraduateInfoService graduateService;
	
	/**
	 * 查询毕业生基本信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryBasicInfoById")
	public void queryBasicInfoById(HttpServletRequest request,HttpServletResponse response){
		try {
			Long userId = this.getUserId(request);
			GraduateInfo graduateInfo = this.graduateService.queryBasicInfoById(userId);
			WebUtils.printSuccess(request, response, graduateInfo);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/doUpdate")
	public void doSave(HttpServletRequest request,HttpServletResponse response,GraduateInfo graduate) throws ParseException{
		Long userId = this.getUserId(request);
		GraduateInfo graduateInfo = this.graduateService.queryBasicInfoById(userId);
		graduateInfo.setSno(graduate.getSno());
		graduateInfo.setName(graduate.getName());
		graduateInfo.setSex(graduate.getSex());
		graduateInfo.setBirthday(graduate.getBirthday());
		graduateInfo.setNation(graduate.getNation());
		graduateInfo.setProvince(graduate.getProvince());
		graduateInfo.setCity(graduate.getCity());
		graduateInfo.setPoliticalStatus(graduate.getPoliticalStatus());
		graduateInfo.setTel(graduate.getTel());
		graduateInfo.setQq(graduate.getQq());
		graduateInfo.setWchat(graduate.getWchat());
		graduateInfo.setDept(graduate.getDept());
		graduateInfo.setSpecialty(graduate.getSpecialty());
		graduateInfo.setEducation(graduate.getEducation());
		graduateInfo.setGraduateCollege(graduate.getGraduateCollege());
		graduateInfo.setInDate(graduate.getInDate());
		graduateInfo.setHaveJob(graduate.getHaveJob());
		graduateInfo.setCompanyName(graduate.getCompanyName());
		graduateInfo.setGetJobTime(graduate.getGetJobTime());
		graduateInfo.setIndustry(graduate.getIndustry());
		graduateInfo.setPosition(graduate.getPosition());
		graduateInfo.setMonthSalary(graduate.getMonthSalary());
		graduateInfo.setWorkYear(graduate.getWorkYear());
		
		this.graduateService.doUpdate(graduateInfo);
		WebUtils.printSuccess(request, response);
	}
	
	/**
	 * 查询公司信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/doSearchCompanyInfo")
	public void doSearchCompanyInfo(HttpServletRequest request,HttpServletResponse response){
		try {
			Page page = this.newPage(request);
			Map<String, String> paramMap = this.getParamMap(request);
			WebUtils.printSuccess(request, response, this.graduateService.doSearchCompanyInfo(page,paramMap));
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
}

