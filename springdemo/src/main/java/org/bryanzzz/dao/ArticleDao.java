package org.bryanzzz.dao;

import org.bryanzzz.entity.Article;

public interface ArticleDao {

    /**
     * 根据用户id查找所有文章
     * @param userId
     * @return
     */
    Article getAll(long userId, int offet, int limit);

    /**
     * 更新点击量
     * @param articleId
     * @return
     */
    int increaseClickCount(long articleId);




}
