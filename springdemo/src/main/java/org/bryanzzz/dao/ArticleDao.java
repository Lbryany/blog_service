package org.bryanzzz.dao;

import org.bryanzzz.entity.Article;

import java.util.List;

public interface ArticleDao {

    /**
     * 根据用户id查找所有文章
     * @param userId
     * @return
     */
    List<Article> getAll(long userId, int offset, int limit);

    /**
     * 更新点击量
     * @param articleId
     * @return
     */
    int increaseClickCount(long articleId);

    int createArticle(Article article);




}
