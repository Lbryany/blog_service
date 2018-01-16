package org.bryanzzz.service;

import org.bryanzzz.dto.TagExecution;
import org.bryanzzz.entity.Tag;

public interface TagService {

    TagExecution createTag(Tag tag);

    TagExecution addTagToArticle(long articleId, long tagId);

    TagExecution removeTagToArticle(long articleId, long tagId);

    TagExecution deleteTag(long tagId);

}
