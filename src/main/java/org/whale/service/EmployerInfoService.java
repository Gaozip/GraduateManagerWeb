package org.whale.service;

import org.whale.pojo.EmployerInfo;

/**
* @ClassName： EmployerInfoService
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月26日
*/
public interface EmployerInfoService {

	EmployerInfo getEmployerInfoByUserId(Long userId);

	void doUpdate(EmployerInfo info);

}

