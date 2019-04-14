package org.whale.dao;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.EmployerInfo;

/**
* @ClassName： EmployerInfoMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月24日
*/
public interface EmployerInfoMapper {

	void addLine(EmployerInfo employerInfo);

	EmployerInfo getEmployerInfoByUserId(@Param("userId")Long userId);

	void doUpdate(EmployerInfo info);

}

