package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.DictItem;

/**
* @ClassName： DictItemMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
public interface DictItemMapper {
	
	void doSave(DictItem  dictItem);
	
	void doUpdate(DictItem dictItem);
	
	void doDelete(@Param("pkDictItemId")Long pkDictItemId);
	
	List<DictItem> queryPage(@Param("limitA")int limitA,@Param("limitB")int limitB,@Param("fkDictId")Long fkDictId);
}

