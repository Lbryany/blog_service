package org.bryanzzz.dao;


import org.bryanzzz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    //注入DAO
    @Resource
    private UserDao userDao;

    @Test
    public void testQueryByUsername() throws Exception{
        String username = "lybryan1994cn";
        User user = userDao.queryByUsername(username);
        System.out.println(user.getNickname());
        System.out.println(user);

    }

}
