package org.whale.dao;

import org.whale.pojo.Article;

/**
* @ClassName： ArticleMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月23日
*/
public interface ArticleMapper {

	void doSave(Article article);

//	List<Article> queryPage(@Param("arg0")Integer limitA, @Param("arg1")Integer limitB);

}

