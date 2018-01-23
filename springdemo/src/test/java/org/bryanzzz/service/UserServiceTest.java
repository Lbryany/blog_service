package org.bryanzzz.service;

import org.bryanzzz.dto.UserExecution;
import org.bryanzzz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class UserServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Test
    public void testLogin() throws Exception{
        User testUser = new User();
        testUser.setUsername("lybryan1994cn");
        testUser.setPassword("1111111");
        UserExecution userExecution = userService.userLogin(testUser);
        logger.info("User={}", userExecution);
    }

}
