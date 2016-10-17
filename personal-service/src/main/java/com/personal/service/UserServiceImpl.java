package com.personal.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.personal.dao.UserDao;
import com.personal.entity.User;
import com.personal.entity.UserCustom;



public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}




	@Override
	public Map<String, Object> login(UserCustom userCustom, String loginVerifyCode) {


		Map<String, Object> result = new HashMap<String, Object>();


		/* 数据非空验证 */
		if (null == userCustom.getEmail() || "".equals(userCustom.getEmail()) || null == userCustom.getPassword()) {
			result.put("errorMsg", "邮箱或密码为空！");
			return result;
		}
		
		

		/* 校验验证码 */
		if (null == userCustom.getVerifyCode() || "".equals(userCustom.getVerifyCode())) {
			result.put("errorMsg", "验证码为空！");
			return result;
		}
		if (null == loginVerifyCode || !loginVerifyCode.equals(userCustom.getVerifyCode())) {
			result.put("errorMsg", "验证码错误！");
			return result;
		}

		/* 校验用户名和密码 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", userCustom.getEmail());
		User loginUser = userDao.selectByMap(map);
		if (null == loginUser || null == loginUser.getUid() || "".equals(loginUser.getUid())) {
			result.put("errorMsg", "用户名不存在！");
			return result;
		} else if (!loginUser.getPassword().equals(userCustom.getPassword())) {
			result.put("errorMsg", "密码错误！");
			return result;
		}

		/* 账号是否可用 */
		if ((byte) 0 == loginUser.getStatus()) {
			result.put("errorMsg", "账号未激活！");
			return result;
		} else if ((byte) 2 == loginUser.getStatus()) {
			result.put("errorMsg", "账号已注销！");
			return result;
		}
		result.put("user", loginUser);
		return result;

	}

	@Override
	public void loginOut(HttpSession httpSession) {

		/* 从OnlineUser中删除 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionid", httpSession.getId());

		/* 用户信息从session中删除 */
		httpSession.removeAttribute("user");


	}

	@Override
	public Map<String, Object> getOnlineExisting(HttpSession httpSession) {
		User loginUser = (User) httpSession.getAttribute("user");
		Map<String, Object> restlt = new HashMap<String, Object>();
		if (loginUser != null) {
			restlt.put("success", null);
		} else {
			restlt.put("fail", null);
		}

		return restlt;

	}


}
