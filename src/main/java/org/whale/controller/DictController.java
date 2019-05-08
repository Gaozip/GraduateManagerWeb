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
import org.whale.common.AuthLogin;
import org.whale.pojo.Dict;
import org.whale.pojo.Page;
import org.whale.service.DictService;
import org.whale.utils.WebUtils;

/**
* @ClassName： DictController
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
	
	@Autowired
	private DictService dictService;
	
	@AuthLogin
	@RequestMapping("/doSave")
	public void doSave(HttpServletRequest request,HttpServletResponse response,Dict dict){
		
		try {
			this.dictService.doSave(dict);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据保存失败！");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doUpdate")
	public void doUpdate(HttpServletRequest request,HttpServletResponse response,Dict dict){
		
		try {
			this.dictService.doUpdate(dict);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据更新失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/doDelete")
	public void doDelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("pkDictId")Long pkDictId){
		
		try {
			this.dictService.doDelete(pkDictId);
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
			Page page = this.dictService.queryPage(page2,paramMap);
			WebUtils.printSuccess(request, response, page);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/queryAllDict")
	public void queryAllDict(HttpServletRequest request,HttpServletResponse response){
		
		try {
			List<Dict> dictList = this.dictService.queryAllDict();
			WebUtils.printSuccess(request, response, dictList);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
	
	@AuthLogin
	@RequestMapping("/ifExist")
	public void IfExist(HttpServletRequest request,HttpServletResponse response,@RequestParam("dictCode")String dictCode){
		
		try {
			int num = this.dictService.ifExist(dictCode);
			Map<String, Integer> map = new HashMap<>();
			map.put("num", num);
			WebUtils.printSuccess(request, response, map);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败!");
			e.printStackTrace();
		}
	}
}

