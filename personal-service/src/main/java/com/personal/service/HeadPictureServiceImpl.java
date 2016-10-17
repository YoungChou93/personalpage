package com.personal.service;

import com.personal.dao.HeadPictureDao;
import com.personal.entity.HeadPicture;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/16.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/16
 */
public class HeadPictureServiceImpl implements  HeadPictureService{

    private HeadPictureDao headPictureDao;

    public void setHeadPictureDao(HeadPictureDao headPictureDao) {
        this.headPictureDao = headPictureDao;
    }

    @Override
    public JSONObject getHeadPicture(String page, String rows, String filter) {
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();

        Map<String, Object> map = new HashMap<String, Object>();

        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("filter", filter);


        List<HeadPicture> points = headPictureDao.findHeadPicture(map);
        Long total=headPictureDao.getTotalHeadPicture(map);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,
                new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        jsonArray = JSONArray.fromObject(points, jsonConfig);
        data.put("rows", jsonArray);
        data.put("total", total);
        result.put("data", data);
        return result;
    }

    @Override
    public void enable(Integer id) {

    }

    @Override
    public void disable(Integer id) {

    }
}
