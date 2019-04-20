package org.whale.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* @ClassName： PageMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年3月19日
*/
public interface PageMapper {

	List<HashMap<?, ?>> queryPageAll(@Param("args1")String tableName, @Param("args2")int limitA, @Param("args3")int limitB);

	Long queryTotalNumAll(@Param("args1")String sql);
	
	@SuppressWarnings("rawtypes")
	List<HashMap> queryPage(@Param("args1")String sql, @Param("args2")int limitA, @Param("args3")int limitB);
	
	Long queryTotalNum(@Param("args1")String sql);

	HashMap<String,Object> queryPageById(@Param("pkId")Long pkId, @Param("tableName")String tableName,@Param("pkName")String pkName);

	String getPkNameByTableName(@Param("tableName")String tableName);

	List<HashMap<String, Object>> queryPageByFkId(@Param("fkId")Long fkId, @Param("tableName")String tableName, @Param("fkName")String fkIdName);

	
	
}

