package org.whale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.EmployerInfoMapper;
import org.whale.pojo.EmployerInfo;
import org.whale.service.EmployerInfoService;

/**
* @ClassName： EmployerInfoServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月26日
*/
@Service
public class EmployerInfoServiceImpl implements EmployerInfoService {

	@Autowired
	private EmployerInfoMapper employerInfoMapper;
	

	@Override
	public EmployerInfo getEmployerInfoByUserId(Long userId) {
		return employerInfoMapper.getEmployerInfoByUserId(userId);
	}


	@Override
	public void doUpdate(EmployerInfo info) {
		this.employerInfoMapper.doUpdate(info);
	}
}

