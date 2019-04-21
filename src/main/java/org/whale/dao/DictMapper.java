package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.Dict;

/**
* @ClassName： DictDao
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
public interface DictMapper {

	void doSave(Dict dict);
	
	void doUpdate(Dict dict);
	
	void doDelete(@Param("pkDictId")Long pkDictId);
	
	List<Dict> queryPage(@Param("limitA")int limitA,@Param("limitB")int limitB);

	Dict getDictByPkId(@Param("pkDictId")Long pkDictId);

	List<Dict> queryAllDict();

	int ifExist(@Param("dictCode")String dictCode);
}

