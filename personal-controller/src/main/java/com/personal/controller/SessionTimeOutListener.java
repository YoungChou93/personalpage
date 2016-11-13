package com.personal.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.personal.service.UserService;

public class SessionTimeOutListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		System.out.println("A new session is created:" + e.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		HttpSession session = e.getSession(); // 获取当前触发事件的session
		System.out.println("session:" + session.getId() + " is destroyed");
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(e.getSession().getServletContext());
		if (session.getAttribute("user") != null) {
			UserService userService = (UserService) ctx.getBean("userService");
			try {
				userService.loginOut(session);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("session:" + session.getId() + " is delete from Table OnlineUser");
	}

}
