package org.bryanzzz.service.impl;

import org.bryanzzz.dao.ArticleDao;
import org.bryanzzz.dao.TagDao;
import org.bryanzzz.dto.ArticleDetail;
import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.Tag;
import org.bryanzzz.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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
        articleDao.createArticle(articleDetail.getArticle());
        //TODO 验证tag是否存在，有一个不存在就报错，验证方式为select In  count
        //构造tagId  List
        List<Long> tagIds = new ArrayList<Long>();
        for (Tag tag:articleDetail.getTag()){
            tagIds.add(tag.getTagId());
        }
        int tagCount = tagDao.getTagCountByTagId(tagIds);
        if(tagCount != articleDetail.getTag().size()){
            //TODO 报错，标签错误
        }
        int addRes = tagDao.createTagRelation(tagIds, articleDetail.getArticle().getArticleId());
        if(addRes == 0){
            //TODO 报错，新增失败
        }
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
