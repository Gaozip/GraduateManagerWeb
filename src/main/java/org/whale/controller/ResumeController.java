package org.whale.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whale.pojo.Page;
import org.whale.pojo.Resume;
import org.whale.pojo.ResumeProject;
import org.whale.pojo.ResumeWork;
import org.whale.service.ResumeService;
import org.whale.utils.StringUtils;
import org.whale.utils.WebUtils;

import com.alibaba.fastjson.JSONObject;

/**
* @ClassName： ResumeController
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月19日
*/
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController {
	
	@Autowired
	private ResumeService resumeService;
	
	/**
	 * 新建简历
	 * @param request
	 * @param response
	 * @param resume:简历实体
	 * @param workTableData:工作经验
	 * @param projectTableData:项目经验
	 */
	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,Resume resume,String workTableData,String projectTableData){
		
		if(StringUtils.isBlank(workTableData) || StringUtils.isBlank(projectTableData) || resume == null){
			return;
		}
		
		try {
			resume.setFkUserId(this.getUserId(request));
			resume.setIsValid((short)1);
			
			List<ResumeWork> workList = JSONObject.parseArray(workTableData, ResumeWork.class);
			List<ResumeProject> projectList = JSONObject.parseArray(projectTableData, ResumeProject.class);
			
			resumeService.doSave(resume,workList,projectList);
			
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据保存失败!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询我的简历列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response){
		Page page = this.newPage(request);
		Long userId = this.getUserId(request);
		Map<String, String> paramMap = this.getParamMap(request);
		try {
			Page pages = resumeService.queryResumePage(page, paramMap,userId);
            WebUtils.printSuccess(request, response, pages);
        } catch (Exception e) {
            e.printStackTrace();
            WebUtils.printFail(request, response, "查询列表数据失败!");
        }
	}
	
	/**
	 * 根据简历id修改我的简历
	 * @param request
	 * @param response
	 * @param resumeId:简历id
	 * @param resume
	 * @param workTableData
	 * @param projectTableData
	 */
	@RequestMapping("/doUpdate")
	public void doUpdateByResumeId(HttpServletRequest request,HttpServletResponse response,Resume resume,String workTableData,String projectTableData){
		
		if(StringUtils.isBlank(workTableData) || StringUtils.isBlank(projectTableData) || resume == null){
			return;
		}
		List<ResumeWork> workList = JSONObject.parseArray(workTableData, ResumeWork.class);
		List<ResumeProject> projectList = JSONObject.parseArray(projectTableData, ResumeProject.class);
		
		resumeService.doUpdateByResumeId(resume.getPkResumeId(),resume, workList,projectList);
		
		WebUtils.printSuccess(request, response);
	}
	
	@RequestMapping("/doDelete")
	public void doDelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("resumeId") Long resumeId){

		resumeService.doDeleteByResumeId(resumeId);
		WebUtils.printSuccess(request, response);
	}
	
	/**
	 * 用人单位查询简历
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getResumeByEmployer")
	public void getResumeByEmployer(HttpServletRequest request,HttpServletResponse response){
		Page page = this.newPage(request);
		Map<String, String> paramMap = this.getParamMap(request);
		try {
			Page pages = resumeService.getResumeByEmployer(page,paramMap);
            WebUtils.printSuccess(request, response, pages);
        } catch (Exception e) {
            e.printStackTrace();
            WebUtils.printFail(request, response, "查询列表数据失败!");
        }
	}
	
	
	@RequestMapping("/doSearchByRequire")
	public void doSearchByRequire(HttpServletRequest request,HttpServletResponse response,@RequestParam("resumeId")Long resumeId,String expertIndustry,String education,String sex,@RequestParam("age")Long age,String workYear,String gradCollege,String companyName,String expertJobIntension){
		Page page  = this.newPage(request);
		
			try{
				Page pages = resumeService.doSearchByRequire(page,resumeId,expertIndustry,education,sex,age,workYear,gradCollege,expertJobIntension,(Long)null);
				WebUtils.printSuccess(request, response, pages);
			}catch(Exception e){
				e.printStackTrace();
				WebUtils.printFail(request, response, "查询列表数据失败!");
			}
	}
}

