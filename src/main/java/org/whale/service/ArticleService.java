package org.whale.service;

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

	Page queryPage(Page page);

}

