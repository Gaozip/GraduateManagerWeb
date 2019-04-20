package org.whale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.whale.pojo.Article;

/**
* @ClassName： ArticleMapper
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月23日
*/
public interface ArticleMapper {

	void doSave(Article article);

	List<Article> queryPage(@Param("limitA")int limitA, @Param("limitB")int limitB, @Param("pkArticleId")String pkArticleId);

	Long queryTotalNum();

	Article getArticleByPkId(@Param("pkArticleId")Long pkArticleId);

	void doUpdate(Article article);

	void doDelete(@Param("pkArticleId")Long pkArticleId);


}

