package org.bryanzzz.service.impl;

import org.bryanzzz.dao.ArticleDao;
import org.bryanzzz.dao.TagDao;
import org.bryanzzz.dto.ArticleDetail;
import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.Tag;
import org.bryanzzz.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ArticleDao articleDao;

    private TagDao tagDao;

    public List<Article> getArticleList() {
        return null;
    }

    public ArticleDetail getArticle(long articleId) {
        return null;
    }

    public int createArticle(ArticleDetail articleDetail) {
        return 0;
    }

    public int updateArticle(ArticleDetail articleDetail) {
        return 0;
    }

    public int delArticle(long articleId) {
        return 0;
    }

    public int createTag(Tag tag) {
        return 0;
    }

    public List<ArticleDetail> getArticleByTagId(long tagId) {
        return null;
    }
}
