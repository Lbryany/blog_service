package org.bryanzzz.service.impl;

import org.bryanzzz.dao.ArticleDao;
import org.bryanzzz.dao.TagDao;
import org.bryanzzz.dto.ArticleDetail;
import org.bryanzzz.dto.ArticleExecution;
import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.Tag;
import org.bryanzzz.enums.ArticleStateEnums;
import org.bryanzzz.exception.ArticleException;
import org.bryanzzz.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired //@Resource @Inject
    private ArticleDao articleDao;

    @Autowired
    private TagDao tagDao;

    public List<ArticleDetail> getArticleList(int pageNo, int pageSize) {
        int offset = (pageNo-1)*pageSize;
        List<Article> articles = articleDao.getAll(offset,pageSize);
        List<Long> articleIds = new ArrayList<Long>();
        for(Article article:articles){
            articleIds.add(article.getArticleId());
        }
        return null;
    }

    public ArticleDetail getArticle(long articleId) {
        return null;
    }

    public ArticleExecution createArticle(ArticleDetail articleDetail) {
        articleDao.createArticle(articleDetail.getArticle());
        //构造tagId  List
        List<Long> tagIds = new ArrayList<Long>();
        for (Tag tag:articleDetail.getTag()){
            tagIds.add(tag.getTagId());
        }
        int tagCount = tagDao.getTagCountByTagId(tagIds);
        //验证tag是否存在，有一个不存在就报错
        if(tagCount != articleDetail.getTag().size()){
            // 报错，标签错误
            throw new ArticleException("标签不存在");
        }
        int addRes = tagDao.createTagRelation(tagIds, articleDetail.getArticle().getArticleId());
        if(addRes == 0){
            //报错，新增失败
            throw new ArticleException("新增失败");
        }
        return new ArticleExecution(addRes, ArticleStateEnums.SUCCESS);
    }

    public ArticleExecution updateArticle(ArticleDetail articleDetail) {
        return new ArticleExecution(ArticleStateEnums.SUCCESS);
    }

    public ArticleExecution delArticle(long articleId) {
        return new ArticleExecution(ArticleStateEnums.SUCCESS);
    }

    public int createTag(Tag tag) {
        return 0;
    }

    public List<ArticleDetail> getArticleByTagId(long tagId) {
        return null;
    }
}
