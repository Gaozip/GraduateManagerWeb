package org.whale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.DictItemMapper;
import org.whale.pojo.DictItem;
import org.whale.pojo.Page;
import org.whale.service.DictItemService;

/**
* @ClassName： DictItemServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
@Service
public class DictItemServiceImpl implements DictItemService {

	@Autowired
	private DictItemMapper dictItemMapper;
	
	@Override
	public int ifExist(String itemCode) {
		
		return this.dictItemMapper.ifExist(itemCode);
	}

	@Override
	public void doSave(DictItem dictItem) {
		
		this.dictItemMapper.doSave(dictItem);
	}

	@Override
	public void doUpdate(DictItem dictItem2) {
		
		DictItem dictItem = this.dictItemMapper.getDictItemByPkId(dictItem2.getPkDictItemId());
		dictItem.setItemName(dictItem2.getItemName());
		dictItem.setItemCode(dictItem2.getItemCode());
		dictItem.setItemVal(dictItem2.getItemVal());
		dictItem.setRemark(dictItem2.getRemark());
		dictItem.setDictType(dictItem2.getDictType());
		dictItem.setIsValid(dictItem2.getIsValid());
		dictItem.setFkDictId(dictItem2.getFkDictId());
		this.dictItemMapper.doUpdate(dictItem);
	}

	@Override
	public void doDelete(Long pkDictItemId) {
		
		this.dictItemMapper.doDelete(pkDictItemId);
	}

	@Override
	public Page queryPage(Page page2, Map<String, String> paramMap) {
		
		String itemName = paramMap.get("itemName");
		String itemCode = paramMap.get("itemCode");
		String fkDictId = paramMap.get("pkDictId");
		List<DictItem> dictItemList = this.dictItemMapper.queryPage(page2.getLimitA(), page2.getLimitB(), fkDictId,itemName,itemCode);
		int num = this.dictItemMapper.getTotalNum(fkDictId,itemName,itemCode);
		page2.setTotalNum((long)num);
		page2.setDatas(dictItemList);
		return page2;
	}
}

