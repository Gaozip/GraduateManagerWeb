package org.whale.dao;

import org.whale.pojo.GraduateInfo;

/**
* @ClassName： GraduateInfoMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月24日
*/
public interface GraduateInfoMapper {

	void doSave(GraduateInfo graduateInfo);

	void doUpdate(GraduateInfo graduateInfo);

	void addLine(GraduateInfo graduateInfo);

	GraduateInfo queryBasicInfoById(Long userId);

}

