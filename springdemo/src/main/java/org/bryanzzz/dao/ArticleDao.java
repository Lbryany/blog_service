package org.bryanzzz.dao;

import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.Tag;

import java.util.List;

public interface ArticleDao {

    /**
     * 根据用户id查找所有文章
     * @return
     */
    List<Article> getAll(int offset, int limit);

    Article getArtilceById(long articleId);

    /**
     * 更新点击量
     * @param articleId
     * @return
     */
    int increaseClickCount(long articleId);

    int createArticle(Article article);

    int updateArticle(Article article);





}
