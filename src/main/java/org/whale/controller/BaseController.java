package org.whale.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.whale.pojo.Page;
import org.whale.pojo.User;
import org.whale.utils.WebUtils;

/**
 * @ClassName： BaseController 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年2月3日
 */
public class BaseController {
	
	Long getUserId(HttpServletRequest request){
		return ((User)request.getSession().getAttribute("user")).getPkUserId();
	}
	
	protected Page newPage(HttpServletRequest request) {
		int pageNo = WebUtils.getInt(request, "pageNo", Integer.valueOf(1)).intValue();
		request.getParameter("pageSize");
		int pageSize = WebUtils.getInt(request, "pageSize", Integer.valueOf(20)).intValue();
		if (pageSize < 1) {
			pageSize = 20;
		}

		if (pageNo < 1)
			pageNo = 1;
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);

		request.setAttribute("page", page);
		return page;
	}

	@SuppressWarnings("unchecked")
	protected Map<String, String> getParamMap(HttpServletRequest request) {
		Map<String, String[]> paramMap = request.getParameterMap();
		Map<String, String> returnParamMap = new HashMap<String, String>();
		if ((paramMap != null) && (paramMap.size() > 0)) {
			Set<String> keySet = paramMap.keySet();
			String url_zh_param_prefix = "url_zh_param_";
			for (String key : keySet) {
				String[] values = request.getParameterValues(key);
				if ((values != null) && (values.length > 0)) {
					if (key.startsWith(url_zh_param_prefix)) {
						try {
							String paramVal = URLDecoder.decode(request.getParameter(key), "UTF-8");
							returnParamMap.put(
									key.substring(key.indexOf(url_zh_param_prefix) + url_zh_param_prefix.length()),
									paramVal);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					} else {
						returnParamMap.put(key, StringUtils.join(values, ","));
					}
				}
			}
		}
		return returnParamMap;
	}
}