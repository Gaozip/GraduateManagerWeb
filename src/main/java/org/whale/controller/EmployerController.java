package org.whale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiDevice.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.whale.pojo.EmployerInfo;
import org.whale.pojo.User;
import org.whale.service.EmployerInfoService;
import org.whale.utils.WebUtils;

/**
* @ClassName： EmployerController
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月26日
*/
@Controller
@RequestMapping("/employer")
public class EmployerController extends BaseController{

	@Autowired
	private EmployerInfoService employerInfoService;
	
	@RequestMapping("/doUpdate")
	public void doUpdate(HttpServletRequest request,HttpServletResponse response,EmployerInfo employerInfo){
		
		try {
			EmployerInfo info = this.employerInfoService.getEmployerInfoByUserId(this.getUserId(request));
			
			info.setCompanyName(employerInfo.getCompanyName());
			info.setOrganizationCode(employerInfo.getOrganizationCode());
			info.setRegisterDate(employerInfo.getRegisterDate());
			info.setLegalRepresentative(employerInfo.getLegalRepresentative());
			info.setCompanyType(employerInfo.getCompanyType());
			info.setManagementForms(employerInfo.getManagementForms());
			info.setEmployerNum(employerInfo.getEmployerNum());
			info.setRegisterCapital(employerInfo.getRegisterCapital());
			info.setIndustry(employerInfo.getIndustry());
			info.setHotLine(employerInfo.getHotLine());
			info.setCompanyAddress(employerInfo.getCompanyAddress());
			info.setScopeOfBusiness(employerInfo.getScopeOfBusiness());
			info.setCompanyProfile(employerInfo.getCompanyProfile());
			
			this.employerInfoService.doUpdate(info);
			
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据更新失败!");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getEmployerInfoByUserId")
	public void getEmployerInfoByUserId(HttpServletRequest request,HttpServletResponse response){
		
		try {
			EmployerInfo employerInfo = this.employerInfoService.getEmployerInfoByUserId(this.getUserId(request));
			WebUtils.printSuccess(request, response, employerInfo);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
}

