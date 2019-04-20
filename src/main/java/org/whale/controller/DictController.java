package org.whale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.whale.pojo.Dict;
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
}

