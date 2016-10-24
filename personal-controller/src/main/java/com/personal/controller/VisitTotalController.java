package com.personal.controller;

import com.personal.service.VisitTotalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/10/18.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/18
 */
@Controller
@RequestMapping("/admin")
public class VisitTotalController {

    @Resource
    private VisitTotalService visitTotalService;

    @RequestMapping("/getVisitTotals")
    public String getVisitTotals(@RequestParam(value = "page", required = true) String page,
                                  @RequestParam(value = "rows", required = true) String rows,
                                  @RequestParam(value = "filter", required = false) String filter,
                                  HttpServletResponse httpServletResponse) throws Exception {

        ResponseUtil.write(httpServletResponse,visitTotalService.getVisitTotal(page,rows,filter));
        return null;
    }
}
