package com.personal.controller;

import com.personal.service.VisitRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/10/16.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/16
 */
@Controller
@RequestMapping("/admin")
public class VisitRecordController {

    @Resource
    private VisitRecordService visitRecordService;

    @RequestMapping("/getVisitRecords")
    public String getVisitRecords(@RequestParam(value = "page", required = true) String page,
                                  @RequestParam(value = "rows", required = true) String rows,
                                  @RequestParam(value = "filter", required = false) String filter,
                                  HttpServletResponse httpServletResponse) throws Exception {

        ResponseUtil.write(httpServletResponse,visitRecordService.getVisitRecord(page,rows,filter));
        return null;
    }

}
