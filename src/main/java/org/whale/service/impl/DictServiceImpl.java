package org.whale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.whale.dao.DictItemMapper;
import org.whale.dao.DictMapper;
import org.whale.pojo.Dict;
import org.whale.pojo.Page;
import org.whale.service.DictService;

/**
* @ClassName： DictServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
@Service
@Transactional
public class DictServiceImpl implements DictService {

	@Autowired
	private DictMapper dictMapper;
	
	@Autowired
	private DictItemMapper dictItemMapper;
	
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
	@Transactional
	public void doDelete(Long pkDictId) {
		//先删除字典分类
		this.dictMapper.doDelete(pkDictId);
		//在删除该分类下的所有字典元素
		this.dictItemMapper.doDeleteByFkId(pkDictId);
	}

	@Override
	public Page queryPage(Page page, Map<String, String> paramMap) {
		
		List<Dict> dictList = this.dictMapper.queryPage(page.getLimitA(), page.getLimitB());
		page.setTotalNum((long)dictList.size());
		page.setDatas(dictList);
		
		return page;
	}

	@Override
	public List<Dict> queryAllDict() {
		
		return this.dictMapper.queryAllDict();
	}

	@Override
	public int ifExist(String dictCode) {
		
		return this.dictMapper.ifExist(dictCode);
	}

}

