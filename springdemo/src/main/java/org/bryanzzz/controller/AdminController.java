package org.bryanzzz.controller;

import org.bryanzzz.dto.ArticleDetail;
import org.bryanzzz.dto.ArticleExecution;
import org.bryanzzz.dto.BlogResult;
import org.bryanzzz.dto.UserExecution;
import org.bryanzzz.entity.Article;
import org.bryanzzz.entity.User;
import org.bryanzzz.enums.ExceptionStateEnums;
import org.bryanzzz.service.ArticleService;
import org.bryanzzz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    /**
     * 登录接口 供测试用
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public BlogResult<UserExecution> testLogin(){
        return new BlogResult<UserExecution>(-1, "2123123");
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult<UserExecution> login(@RequestBody User user, HttpSession session){
        BlogResult<UserExecution> result;
        try {
            UserExecution userExecution = userService.userLogin(user);
            //设置session
            session.setAttribute("uid", userExecution.getUid());
            result = new BlogResult<UserExecution>(userExecution.getUserStateEnums().getState(), userExecution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result = new BlogResult<UserExecution>(ExceptionStateEnums.RUNEXCEPTION.getState(), e.getMessage());
        }
        return result;
    }

    /**
     * 发布文章
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult<ArticleExecution> createArticle(@RequestBody ArticleDetail articleDetail){
        BlogResult<ArticleExecution> result;
        try {
            ArticleExecution articleExecution = articleService.createArticle(articleDetail);
            result = new BlogResult<ArticleExecution>(articleExecution.getArticleStateEnums().getState(), articleExecution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result = new BlogResult<ArticleExecution>(ExceptionStateEnums.RUNEXCEPTION.getState(), e.getMessage());
        }
        return result;
    }

}
