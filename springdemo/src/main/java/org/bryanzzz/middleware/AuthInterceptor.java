package org.bryanzzz.middleware;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import org.bryanzzz.common.JsonWebToken;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断请求的是否是需要权限的页面，比如 发布 ，后台管理 ，登出 页面 （已经在拦截器配置xml中做了）
        //判断有没有session
        Object uid = request.getSession().getAttribute("uid");
        //如果uid为空，拦截
        if(uid == null){
            response.sendError(401, "权限认证失败");
            return false;
        }

//            String token = request.getParameter("token");
//
//            //如果token没有传
//            if(token == null){
//                //判断有没有session
//                response.sendError(401, "权限认证失败");
//                return false;
//            }else{
//                //TODO 先写死一个管理员用户
//                try {
//                    long nowMillis = System.currentTimeMillis();
//                    Claims userClaims = JsonWebToken.parseJWT(token);
//                    if(userClaims.getExpiration().getTime() < nowMillis){
//                        response.sendError(401, "token已过期");
//                        return false;
//                    }else if (Integer.parseInt(userClaims.getId()) != 1000){
//                        //写死可登陆的用户id
//                        response.sendError(401, "登录用户不正确");
//                        return false;
//                    }
//                }catch (MalformedJwtException e){
//                    response.sendError(401, "token解码失败");
//                    return false;
//                }
//
//            }

        return true;
    }
}
