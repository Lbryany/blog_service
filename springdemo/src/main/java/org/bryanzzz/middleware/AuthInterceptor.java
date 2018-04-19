package org.bryanzzz.middleware;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断请求的是否是需要权限的页面，比如 发布 ，后台管理 ，登出 页面 （已经在拦截器配置xml中做了）
            String token = request.getParameter("token");

            if(token == null){
                return false;
            }
//        }

        return true;
    }
}
