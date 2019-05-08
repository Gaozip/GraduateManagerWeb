package org.whale.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whale.common.AuthLogin;
import org.whale.pojo.DictItem;
import org.whale.pojo.Page;
import org.whale.service.DictItemService;
import org.whale.utils.WebUtils;

/**
* @ClassName： DictItemController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
@Controller
@RequestMapping("dictItem")
public class DictItemController extends BaseController{

	@Autowired
	private DictItemService dictItemService;
	
	@AuthLogin
	@RequestMapping("/ifExist")
	public void ifExist(HttpServletRequest request,HttpServletResponse response,@RequestParam("itemCode")String itemCode){
		
		try {
			int num = this.dictItemService.ifExist(itemCode);
			Map<String, Integer> map = new HashMap<String,Integer>();
			map.put("num", num);
			WebUtils.printSuccess(request, response, map);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,DictItem dictItem){
		
		try {
			this.dictItemService.doSave(dictItem);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doUpdate")
	public void doUpdate(HttpServletRequest request,HttpServletResponse response,DictItem dictItem){
		
		try {
			this.dictItemService.doUpdate(dictItem);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据更新失败！");
			e.printStackTrace();
		}
	}
	@RequestMapping("/doDelete")
	public void doDelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("pkDictItemId")Long pkDictItemId){
		
		try {
			this.dictItemService.doDelete(pkDictItemId);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据删除失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response){
		
		try {
			Page page2 = this.newPage(request);
			Map<String, String> paramMap = this.getParamMap(request);
			Page page = this.dictItemService.queryPage(page2,paramMap);
			WebUtils.printSuccess(request, response, page);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败！");
			e.printStackTrace();
		}
	}
}

