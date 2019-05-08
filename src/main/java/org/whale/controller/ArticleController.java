package org.whale.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whale.common.AuthLogin;
import org.whale.pojo.Article;
import org.whale.pojo.Page;
import org.whale.service.ArticleService;
import org.whale.utils.WebUtils;

/**
* @ClassName： ArticleController
* @Description：公告
* @author： 皮卡尔稽
* @date：2019年3月18日
*/
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	@AuthLogin
	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,Article article){

		try {
			articleService.doSave(article);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据保存失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response){
		try {
			Page page = this.newPage(request);
			Map<String, String> paramMap = this.getParamMap(request);
			Page pages = articleService.queryPage(page,paramMap);
			
			WebUtils.printSuccess(request, response, pages);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doUpdate")
	public void doUpdate(HttpServletRequest request,HttpServletResponse response,Article article){
		
		try {
			this.articleService.doUpdate(article);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据更新失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doDelete")
	public void doDelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("pkArticleId")Long pkArticleId){
		
		try {
			this.articleService.doDelete(pkArticleId);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据删除失败!");
			e.printStackTrace();
		}
	}
}

