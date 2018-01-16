package org.bryanzzz.service.impl;

import org.bryanzzz.dao.TagDao;
import org.bryanzzz.dto.TagExecution;
import org.bryanzzz.entity.Tag;
import org.bryanzzz.enums.ArticleStateEnums;
import org.bryanzzz.exception.ArticleException;
import org.bryanzzz.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    public TagExecution createTag(Tag tag) {
        int tagRes = tagDao.createTag(tag);
        if(tagRes == 0)
            throw new ArticleException("创建标签失败");
        return new TagExecution(tagRes, ArticleStateEnums.SUCCESS);
    }

    public TagExecution deleteTag(long tagId) {
        int tagRes = tagDao.deleteTag(tagId);
        if(tagRes == 0)
            throw new ArticleException("删除标签失败");
        return new TagExecution(ArticleStateEnums.SUCCESS);
    }

    public TagExecution addTagToArticle(long articleId, long tagId) {
        Tag tag = tagDao.getTagByTagId(tagId);
        if(tag == null){
            throw new ArticleException("标签不存在");
        }
        int tagRes = tagDao.addTagToArticle(articleId, tagId);
        if(tagRes == 0){
            throw new ArticleException("文章标签新增失败");
        }
        return new TagExecution(ArticleStateEnums.SUCCESS);
    }

    public TagExecution removeTagToArticle(long articleId, long tagId) {
        int tagRes = tagDao.removeTagToArticle(articleId, tagId);
        if(tagRes == 0)
            throw new ArticleException("移除文章标签失败");
        return new TagExecution(ArticleStateEnums.SUCCESS);
    }
}
