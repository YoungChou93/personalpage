package com.personal.service;

import com.personal.dao.HeadPictureDao;
import com.personal.entity.HeadPicture;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        HeadPicture headPicture=headPictureDao.selectByPrimaryKey(id);
        headPicture.setStatus(true);
        headPictureDao.updateByPrimaryKeySelective(headPicture);
    }

    @Override
    public void disable(Integer id) {
        HeadPicture headPicture=headPictureDao.selectByPrimaryKey(id);
        headPicture.setStatus(false);
        headPictureDao.updateByPrimaryKeySelective(headPicture);
    }

    @Override
    public void addHeadPicture(HeadPicture headPicture, MultipartFile photo, String path) throws IOException {
        SimpleDateFormat myformat = new SimpleDateFormat("yyyyMMdd");
        String date = myformat.format(new Date()); // id前缀
        String oldFileNme = photo.getOriginalFilename();
        String newFileName = date + CommonUtils.uuid() + oldFileNme.substring(oldFileNme.lastIndexOf("."));
        System.out.println(newFileName);
        File newFile = new File(path + "res"+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+ newFileName);
        photo.transferTo(newFile);
        headPicture.setPhotourl("/res/img/"+newFileName);
        headPicture.setUploaddate(new Date());
        headPictureDao.insertSelective(headPicture);
    }

    @Override
    public void deleteHeadPicture(Integer id, String path) {
        HeadPicture headPicture=headPictureDao.selectByPrimaryKey(id);
        File file = new File(path+headPicture.getPhotourl().substring(1));
        file.delete();
        headPictureDao.deleteByPrimaryKey(id);
    }
}
