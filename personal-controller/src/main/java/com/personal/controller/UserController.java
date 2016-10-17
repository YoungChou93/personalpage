package com.personal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personal.entity.UserCustom;
import com.personal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	/**
	 *
	 * @param httpServletRequest
	 * @param userCustom
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest httpServletRequest,
							  HttpServletResponse response,
							  UserCustom userCustom, BindingResult bindingResult)
					throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView();

		/** springMVC校验 **/
		String errorMsg = "";
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				errorMsg = errorMsg + objectError.getDefaultMessage();
			}
			mav.addObject("errorMsg", errorMsg);
			mav.addObject("userCustom", userCustom);
			mav.setViewName("/login");
			return mav;
		}
		HttpSession httpSession=httpServletRequest.getSession();
		String loginVerifyCode=(String)httpSession.getAttribute("verifyCode");
		result = userService.login(userCustom, loginVerifyCode);
		if (result.containsKey("errorMsg")) {
			mav.addObject("errorMsg", result.get("errorMsg"));// 添加错误信息
			mav.addObject("userCustom", userCustom);// 数据回显
			mav.setViewName("/login");// 设置视图
		} else {
			httpSession.setAttribute("user",result.get("user"));
			mav.setViewName("redirect:/admin.action");
		}
		return mav;
	}



	@RequestMapping("/timer")
	public String timer(HttpSession httpSession, HttpServletResponse response) throws Exception {
		Map<String, Object> restlt = userService.getOnlineExisting(httpSession);
		JSONObject jsonObject = new JSONObject();
		if (restlt.containsKey("success")) {
			jsonObject.put("success", true);
		} else {
			jsonObject.put("success", false);
		}
		ResponseUtil.write(response, jsonObject);
		return null;
	}


	@RequestMapping("/getVerifyCode")
	public void getVerifyCode(HttpServletResponse response,HttpSession httpSession) throws IOException {

		response.setHeader("Content-Type","image/jped");
		VerifyCode vc = new VerifyCode();
		VerifyCode.output(vc.getImage(), response.getOutputStream());
		httpSession.setAttribute("verifyCode", vc.getText());

	}

}
