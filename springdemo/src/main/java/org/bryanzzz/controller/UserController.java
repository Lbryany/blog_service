package org.bryanzzz.controller;

import org.bryanzzz.dto.BlogResult;
import org.bryanzzz.dto.UserExecution;
import org.bryanzzz.entity.User;
import org.bryanzzz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/login", method = RequestMethod.GET)
    @ResponseBody
    public BlogResult<UserExecution> testLogin(){
        logger.error("aasdasd");
        return new BlogResult<UserExecution>(false, "2123123");
    }

    @RequestMapping(name = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult<UserExecution> login(@RequestBody User user){
        BlogResult<UserExecution> result;
        try {
            UserExecution userExecution = userService.userLogin(user);
            result = new BlogResult<UserExecution>(true, userExecution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result = new BlogResult<UserExecution>(false, e.getMessage());
        }
        return result;
    }

}
