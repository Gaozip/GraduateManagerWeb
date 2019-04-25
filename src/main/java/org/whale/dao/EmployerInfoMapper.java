package org.whale.dao;

import java.util.List;

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

	List<EmployerInfo> doSearchCompanyInfo(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("companyName")String companyName, @Param("organizationCode")String organizationCode,
			@Param("legalRepresentative")String legalRepresentative, @Param("companyType")String companyType, @Param("industry")String industry, @Param("employerNum")String employerNum, @Param("registerCapital")String registerCapital,
			@Param("beginRegisterDate")String beginRegisterDate, @Param("endRegisterDate")String endRegisterDate, @Param("fUZZY_WORD")String fUZZY_WORD);

	int getTotalNum(@Param("companyName")String companyName, @Param("organizationCode")String organizationCode,
			@Param("legalRepresentative")String legalRepresentative, @Param("companyType")String companyType, @Param("industry")String industry, @Param("employerNum")String employerNum, @Param("registerCapital")String registerCapital,
			@Param("beginRegisterDate")String beginRegisterDate, @Param("endRegisterDate")String endRegisterDate, @Param("fUZZY_WORD")String fUZZY_WORD);

}

