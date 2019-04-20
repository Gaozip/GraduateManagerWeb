package org.whale.service;

import java.util.Map;

import org.whale.pojo.Article;
import org.whale.pojo.Page;

/**
* @ClassName： ArticleService
* @Description：
* @author： 皮卡尔稽
* @date：2019年3月18日
*/
public interface ArticleService {

	void doSave(Article article);

	Page queryPage(Page page, Map<String, String> paramMap);

	void doUpdate(Article article);

	void doDelete(Long pkArticleId);

}

