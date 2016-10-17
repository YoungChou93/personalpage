package com.personal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public ModelAndView getAdmin(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/admin");
        return mav;
    }



}
