package org.bryanzzz.dao;

import org.bryanzzz.entity.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getTagByArticle(long articleId);

    List<Tag> getTagByUser(long userId);

//    int createTag(Tag tag);



}
