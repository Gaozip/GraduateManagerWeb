package org.whale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whale.dao.ArticleMapper;
import org.whale.pojo.Article;
import org.whale.pojo.Page;
import org.whale.service.ArticleService;
import org.whale.utils.StringUtils;

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
	
	@Override
	public void doSave(Article article) {
		articleMapper.doSave(article);
	}

	@Override
	public Page queryPage(Page page,Map<String, String> paramMap) {
		
		String pkArticleId = paramMap.get("pkArticleId");
		List<Article> articleList = this.articleMapper.queryPage(page.getLimitA(),page.getLimitB(),pkArticleId);
		page.setDatas(articleList);
		Long totalNum = this.articleMapper.queryTotalNum();
		if(StringUtils.isNotBlank(pkArticleId)){
			page.setTotalNum(1L);
		}else{
			page.setTotalNum(totalNum);
		}
		
		return page;
	}

	@Override
	public void doUpdate(Article article2) {
		Article article = this.articleMapper.getArticleByPkId(article2.getPkArticleId());
		article.setArticleItem(article2.getArticleItem());
		article.setArticleType(article2.getArticleType());
		article.setStartTime(article2.getStartTime());
		article.setIsValid(article2.getIsValid());
		article.setIsTop(article2.getIsTop());
		article.setArticleBody(article2.getArticleBody());
		this.articleMapper.doUpdate(article);
	}

	@Override
	public void doDelete(Long pkArticleId) {
		this.articleMapper.doDelete(pkArticleId);
	}
	
}

