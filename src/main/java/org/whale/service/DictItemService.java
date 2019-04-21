package org.whale.service;

import java.util.Map;

import org.whale.pojo.DictItem;
import org.whale.pojo.Page;

/**
* @ClassName： DictItemService
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
public interface DictItemService {

	int ifExist(String itemCode);

	void doSave(DictItem dictItem);

	void doUpdate(DictItem dictItem);

	void doDelete(Long pkDictItemId);

	Page queryPage(Page page2, Map<String, String> paramMap);

}

