package org.bryanzzz.service;

import org.bryanzzz.dto.ArticleDetail;
import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.Tag;

import java.util.List;

/**
 * 业务接口
 * 方法定义粒度   参数   返回类型   站在使用者角度
 */
public interface ArticleService {

    /**
     * 文章列表接口
     * @return Article
     */
    List<Article> getArticleList();

    /**
     * 文章详情接口
     * @return Article
     */
    ArticleDetail getArticle(long articleId);

    /**
     *  创建文章
     * @param articleDetail
     * @return
     */
    int createArticle(ArticleDetail articleDetail);

    int updateArticle(ArticleDetail articleDetail);

    int delArticle(long articleId);

    /**
     * 创建标签
     * @param tag
     * @return
     */
    int createTag(Tag tag);

    /**
     * 按照标签获取文章
     * @param tagId
     * @return
     */
    List<ArticleDetail> getArticleByTagId(long tagId);

}
