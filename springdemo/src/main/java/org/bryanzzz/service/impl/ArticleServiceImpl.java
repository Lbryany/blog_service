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
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Long> articleIds = new ArrayList<>();
        if(articles == null){
            throw new ArticleException("文章为空");
        }
        for(Article article:articles){
            articleIds.add(article.getArticleId());
        }
        List<Tag> tags = tagDao.getByArticleIds(articleIds);
        //用stream解决 list to map 转换（好好学stream）
        Map<Long, List<Tag>> tagsMap = tags.stream().filter(tag -> tag.getTagId() != 0).collect(Collectors.groupingBy(Tag::getArticleId));
        List<ArticleDetail> articleRes = new ArrayList<>();
        for(Article article:articles){
            ArticleDetail articleDetail = new ArticleDetail(article, tagsMap.get(article.getArticleId()));
            articleRes.add(articleDetail);
        }
        return articleRes;
    }

    public ArticleDetail getArticle(long articleId) {
        Article article = articleDao.getArtilceById(articleId);
        List<Tag> tags = tagDao.getTagByArticle(articleId);
        ArticleDetail articleDetail = new ArticleDetail(article, tags);
        return articleDetail;
    }

    public ArticleExecution createArticle(ArticleDetail articleDetail) {
        articleDao.createArticle(articleDetail.getArticle());
        //构造tagId  List
        List<Long> tagIds = new ArrayList<>();
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

    public ArticleExecution updateArticle(Article article) {
        int updateRes = articleDao.updateArticle(article);
        if(updateRes == 0){
            //报错，新增失败
            throw new ArticleException("更新失败");
        }
        return new ArticleExecution(updateRes, ArticleStateEnums.SUCCESS);
    }

    public ArticleExecution delArticle(long articleId) {
        return new ArticleExecution(ArticleStateEnums.SUCCESS);
    }


    public List<ArticleDetail> getArticleByTagId(long tagId) {
        return null;
    }
}
