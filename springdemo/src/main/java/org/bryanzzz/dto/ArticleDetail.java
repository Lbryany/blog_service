package org.bryanzzz.dto;

import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.Tag;

import java.util.List;

public class ArticleDetail {

    private Article article;

    private List<Tag> tag;

    public ArticleDetail(Article article, List<Tag> tag) {
        this.article = article;
        this.tag = tag;
    }

    public Article getArticle() {

        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }
}
