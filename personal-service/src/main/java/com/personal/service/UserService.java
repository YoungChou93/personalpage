package com.personal.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.personal.entity.UserCustom;
import org.springframework.web.multipart.MultipartFile;

import com.personal.entity.User;

import net.sf.json.JSONObject;


public interface UserService {
	

	

	
	/**
	 * 
	 * @brief 用户登录
	 * @param userCustom
	 * @author zhouyang
	 * @date 2016年3月4日 下午2:37:35
	 */
	public Map<String,Object> login(UserCustom userCustom, String loginVerifyCode)throws Exception;
	
	/**
	 *
	 * @brief 用户登出
	 * @param userCustom
	 * @param httpServletRequest
	 * @author zhouyang
	 * @date 2016年3月4日 下午7:31:20
	 */
	public void loginOut(HttpSession httpSession)throws Exception;

	
	/**
	 * 
	 * @brief 判断用户是否还在登录状态
	 * @param httpSession
	 * @author zhouyang
	 * @date 2016年3月6日 下午7:17:36
	 */
	public Map<String, Object> getOnlineExisting(HttpSession httpSession)throws Exception;
	
	


}
