package org.whale.service;

import org.whale.pojo.Dict;

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

}

