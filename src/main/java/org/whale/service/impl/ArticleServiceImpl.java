package org.whale.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.ArticleMapper;
import org.whale.pojo.Article;
import org.whale.pojo.Page;
import org.whale.service.ArticleService;
import org.whale.utils.PageUtils;

/**
* @ClassName： ArticleServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年3月18日
*/
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	
	@Resource(name="pageUtils")
	private PageUtils pageUtils;
	
	@Override
	public void doSave(Article article) {
		articleMapper.doSave(article);
	}

	@Override
	public Page queryPage(Page page) {
		
		return pageUtils.queryPageAll(page, "sys_article");
	}
	
}

