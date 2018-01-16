package org.bryanzzz.dto;

import org.bryanzzz.enums.ArticleStateEnums;

public class TagExecution {

    private long tagId;

    private ArticleStateEnums articleStateEnums;

    public long getTagId() {
        return tagId;
    }

    public ArticleStateEnums getArticleStateEnums() {
        return articleStateEnums;
    }

    @Override
    public String toString() {
        return "TagExecution{" +
                "tagId=" + tagId +
                ", articleStateEnums=" + articleStateEnums +
                '}';
    }

    public TagExecution(long tagId, ArticleStateEnums articleStateEnums) {
        this.tagId = tagId;
        this.articleStateEnums = articleStateEnums;
    }

    public TagExecution(ArticleStateEnums articleStateEnums) {
        this.articleStateEnums = articleStateEnums;
    }
}
