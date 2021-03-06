package org.bryanzzz.service;

import org.bryanzzz.dto.ArticleDetail;
import org.bryanzzz.dto.ArticleExecution;
import org.bryanzzz.entity.Article;

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
    List<ArticleDetail> getArticleList(int pageNo, int pageSize);

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
    ArticleExecution createArticle(ArticleDetail articleDetail);

    ArticleExecution updateArticle(Article article);

    ArticleExecution delArticle(long articleId);


    /**
     * 按照标签获取文章
     * @param tagId
     * @return
     */
    List<Article> getArticleByTagId(long tagId);

}
