package org.bryanzzz.dao;

import org.bryanzzz.entity.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getTagByArticle(long articleId);

    List<Tag> getTagByUser(long userId);

    int createTag(Tag tag);

    int createTagRelation(List<Long> tagId, long articleId);

    int getTagCountByTagId(List<Long> tagId);

    List<Tag> getByArticleIds(List<Long> articleIds);

    int deleteTag(long tagId);

    int addTagToArticle(long articleId, long tagId);

    int removeTagToArticle(long articleId, long tagId);

    Tag getTagByTagId(long tagId);


}
