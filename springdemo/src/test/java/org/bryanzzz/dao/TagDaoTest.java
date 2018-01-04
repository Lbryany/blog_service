package org.bryanzzz.dao;

import org.bryanzzz.entity.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TagDaoTest {

    @Resource
    private TagDao tagDao;

    @Test
    public void testCreateTag() throws Exception{

        Tag testTag = new Tag();
        testTag.setTagName("单元测试1");
        testTag.setUserId(1000);
        int testRes = tagDao.createTag(testTag);
        System.out.println(testRes);

    }



}
