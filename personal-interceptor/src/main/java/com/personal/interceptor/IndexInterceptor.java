package com.personal.interceptor;

import com.personal.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Created by Administrator on 2016/10/18.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/18
 */
public class IndexInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url=httpServletRequest.getRequestURI();
        User user=(User) httpServletRequest.getSession().getAttribute("user");

        if(user!=null && url.indexOf("admin")>=0 && !user.getRole().equals((byte)0)){
            httpServletRequest.getSession().setAttribute("message", "没有权限");
            httpServletRequest.getRequestDispatcher("/error.jsp").forward(httpServletRequest, httpServletResponse);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
