package org.bryanzzz.middleware;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //TODO 判断请求的是否是需要权限的页面，比如 发布 ，后台管理 ，登出 页面
        if(request.getServletPath().startsWith("admin")){

        }


        //获取token进行判断
        String token = request.getParameter("token");

        if(token == null){
            return false;
        }



        return true;
    }
}
