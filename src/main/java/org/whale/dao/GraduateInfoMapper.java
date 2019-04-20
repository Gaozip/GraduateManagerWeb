package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	GraduateInfo queryBasicInfoById(@Param("userId")Long userId);

	List<Long> queryIdByRequire(@Param("name")String name, @Param("age")String age, @Param("sex")String sex, @Param("province")String province, @Param("city")String city, @Param("education")String education,
			@Param("gradCollege")String gradCollege, @Param("specialty")String specialty, @Param("workYear")String workYear, @Param("fUZZY_WORD")String fUZZY_WORD);
}

