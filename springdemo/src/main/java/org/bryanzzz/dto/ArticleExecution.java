package org.bryanzzz.dto;

import org.bryanzzz.enums.ArticleStateEnums;

/**
 * 文章增删改查结果返回
 */
public class ArticleExecution {

    private long articleId;

    private ArticleStateEnums articleStateEnums;


    private ArticleDetail articleDetail;

    public long getArticleId() {
        return articleId;
    }

    public ArticleStateEnums getArticleStateEnums() {
        return articleStateEnums;
    }

    public ArticleDetail getArticleDetail() {
        return articleDetail;
    }


    @Override
    public String toString() {
        return "ArticleExecution{" +
                "articleId=" + articleId +
                ", articleStateEnums=" + articleStateEnums +
                ", articleDetail=" + articleDetail +
                '}';
    }

    public ArticleExecution(long articleId, ArticleStateEnums articleStateEnums, ArticleDetail articleDetail) {
        this.articleId = articleId;
        this.articleStateEnums = articleStateEnums;
        this.articleDetail = articleDetail;
    }

    public ArticleExecution(ArticleStateEnums articleStateEnums, ArticleDetail articleDetail) {
        this.articleStateEnums = articleStateEnums;
        this.articleDetail = articleDetail;
    }

    public ArticleExecution(long articleId, ArticleStateEnums articleStateEnums) {
        this.articleId = articleId;
        this.articleStateEnums = articleStateEnums;
    }

    public ArticleExecution(ArticleStateEnums articleStateEnums) {
        this.articleStateEnums = articleStateEnums;
    }
}
