package com.personal.controller;

import com.personal.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */

@Controller
public class IndexController {

    @Resource
    private IndexService indexService;

    @RequestMapping("/getIndex")
    public ModelAndView getIndex(HttpServletRequest httpServletRequest) throws Exception {
        ModelAndView mav = new ModelAndView();
        Map<String,Object> result=indexService.visitIndex(ClientIPUtils.getClientIp(httpServletRequest),httpServletRequest.getSession().getId());
        mav.addObject("headpicture",result.get("headpicture"));
        mav.addObject("personal",result.get("personal"));
        mav.addObject("today",result.get("today"));
        mav.addObject("total",result.get("total"));

        mav.setViewName("/index");
        return mav;
    }

}
