package org.whale.dao;

import org.apache.ibatis.annotations.Param;

/**
* @ClassName： UtilMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月20日
*/
public interface UtilMapper {

	String getDictItemVal(@Param("itemCode")String itemCode);

}

