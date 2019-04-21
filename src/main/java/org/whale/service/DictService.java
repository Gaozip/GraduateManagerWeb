package org.whale.service;

import java.util.List;
import java.util.Map;

import org.whale.pojo.Dict;
import org.whale.pojo.Page;

/**
* @ClassName： DictService
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
public interface DictService {

	void doSave(Dict dict);

	void doUpdate(Dict dict);

	void doDelete(Long pkDictId);

	Page queryPage(Page page2, Map<String, String> paramMap);

	List<Dict> queryAllDict();

	int ifExist(String dictCode);

}

