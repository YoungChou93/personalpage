package com.personal.controller;

import com.personal.entity.HeadPicture;
import com.personal.service.HeadPictureService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/10/16.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/16
 */
@Controller
@RequestMapping("/admin")
public class HeadPictureCotroller {

    @Resource
    private HeadPictureService headPictureService;

    @RequestMapping("/addHeadPicture")
    public ModelAndView addHeadPicture(HeadPicture headPicture, @RequestParam(value = "file", required = true) MultipartFile photo, HttpServletRequest httpServletRequest)throws Exception {
        ModelAndView mav=new ModelAndView();
        headPictureService.addHeadPicture(headPicture,photo,httpServletRequest.getSession().getServletContext().getRealPath("/"));
        mav.setViewName("/admin/headpicture");
        return mav;
    }

    @RequestMapping("/getHeadPictures")
    public String getHeadPictures(@RequestParam(value = "page", required = true) String page,
                               @RequestParam(value = "rows", required = true) String rows,
                               @RequestParam(value = "filter", required = false) String filter,
                               HttpServletResponse httpServletResponse) throws Exception {

        ResponseUtil.write(httpServletResponse,headPictureService.getHeadPicture(page,rows,filter));
        return null;
    }

    @RequestMapping("/enableHeadPicture")
    public String enable(@RequestParam(value = "id", required = true) Integer id,
                         HttpServletResponse httpServletResponse) throws Exception {
        headPictureService.enable(id);
        JSONObject result=new JSONObject();
        result.put("success",true);
        ResponseUtil.write(httpServletResponse,result);
        return null;
    }

    @RequestMapping("/disableHeadPicture")
    public String disable(@RequestParam(value = "id", required = true) Integer id,
                          HttpServletResponse httpServletResponse) throws Exception {
        headPictureService.disable(id);
        JSONObject result=new JSONObject();
        result.put("success",true);
        ResponseUtil.write(httpServletResponse,result);
        return null;
    }

    @RequestMapping("/deleteHeadPicture")
    public String delete(@RequestParam(value = "id", required = true) Integer id,
                         HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws Exception {
        headPictureService.deleteHeadPicture(id,httpServletRequest.getSession().getServletContext().getRealPath("/"));
        JSONObject result=new JSONObject();
        result.put("success",true);
        ResponseUtil.write(httpServletResponse,result);
        return null;
    }
}
