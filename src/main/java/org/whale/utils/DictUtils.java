package org.whale.utils;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.whale.dao.UtilMapper;

/**
* @ClassName： DictUtils
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
@Component
public class DictUtils {

	@Resource
	private UtilMapper utilMapper;
	
	public String getDictItemByItemCode(String itemCode){

		return utilMapper.getDictItemVal(itemCode);
	}
}

