package org.whale.utils;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.whale.dao.PageMapper;
import org.whale.pojo.Page;


/**
 * @ClassName： PageUtils 
 * @Description： 简单的分页查询功能，类似mysql的limit
 * @author： 皮卡尔稽
 * @date：2019年3月19日
 */
@Component
public class PageUtils {

	@Autowired
	private PageMapper pageMapper;
	
	public PageUtils(){}
	
	/**
	 * 查询所有数据，不带条件
	 * @param page
	 * @param tableName 表名
	 * @return
	 */
	public Page queryPageAll(Page page,String tableName) {
		page.setTotalNum(pageMapper.queryTotalNumAll(tableName));
		@SuppressWarnings("rawtypes")
		List<HashMap> list = pageMapper.queryPageAll(tableName, page.getLimitA(), page.getLimitB());
		page.setDatas(list);
		return page;
	}
	
	public Page queryPage(Page page){
		page.setTotalNum(pageMapper.queryTotalNum(page.getSql()));
		@SuppressWarnings("rawtypes")
		List<HashMap> list = pageMapper.queryPage(page.getSql(), page.getLimitA(), page.getLimitB());
		page.setDatas(list);
		return page;
	}
	
	/**
	 * 根据主键获取数据-结果只有一条
	 * @param pkId
	 * @param tableName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public HashMap queryPageById(Long pkId,String tableName){
		
		String pkName = pageMapper.getPkNameByTableName(tableName);
		return pageMapper.queryPageById(pkId,tableName,pkName);
	}
	
	
	@SuppressWarnings("rawtypes")
	public HashMap queryPageByFkId(Long fkId,String tableName,String fkIdName){
		
		return pageMapper.queryPageByFkId(fkId,tableName,fkIdName);
	}
}
