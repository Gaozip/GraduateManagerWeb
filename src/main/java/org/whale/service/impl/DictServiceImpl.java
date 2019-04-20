package org.whale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.DictMapper;
import org.whale.pojo.Dict;
import org.whale.service.DictService;

/**
* @ClassName： DictServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictMapper dictMapper;
	
	@Override
	public void doSave(Dict dict) {
		this.dictMapper.doSave(dict);
	}

	@Override
	public void doUpdate(Dict dict2) {
		Dict dict = this.dictMapper.getDictByPkId(dict2.getPkDictId());
		dict.setDictName(dict2.getDictCode());
		dict.setDictName(dict2.getDictName());
		dict.setIsValid(dict2.getIsValid());
		dict.setRemark(dict2.getRemark());
		this.dictMapper.doUpdate(dict);
	}

	@Override
	public void doDelete(Long pkDictId) {
		
	}

}

