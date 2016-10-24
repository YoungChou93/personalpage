package com.personal.service;

import com.personal.dao.PersonalDao;
import com.personal.entity.Personal;
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
public class PersonalServiceImpl implements PersonalService {

    private PersonalDao personalDao;

    public void setPersonalDao(PersonalDao personalDao) {
        this.personalDao = personalDao;
    }

    @Override
    public void addPersonalService(Personal personal,MultipartFile photo,String path) throws IOException {
        SimpleDateFormat myformat = new SimpleDateFormat("yyyyMMdd");
        String date = myformat.format(new Date()); // id前缀
        String oldFileNme = photo.getOriginalFilename();
        String newFileName = date + CommonUtils.uuid() + oldFileNme.substring(oldFileNme.lastIndexOf("."));
        System.out.println(newFileName);
        File newFile = new File(path + "res"+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+ newFileName);
        photo.transferTo(newFile);
        personal.setPhotourl("/res/img/"+newFileName);
        personal.setUploaddate(new Date());
        personalDao.insertSelective(personal);
    }

    @Override
    public void deletePersonalService(Integer id,String path) {
        Personal personal=personalDao.selectByPrimaryKey(id);
        File file = new File(path+personal.getPhotourl().substring(1));
        file.delete();
        personalDao.deleteByPrimaryKey(id);
    }

    @Override
    public void enable(Integer id) {
        Personal personal=personalDao.selectByPrimaryKey(id);
        personal.setStatus(true);
        personalDao.updateByPrimaryKeySelective(personal);
    }

    @Override
    public void disable(Integer id) {
        Personal personal=personalDao.selectByPrimaryKey(id);
        personal.setStatus(false);
        personalDao.updateByPrimaryKeySelective(personal);
    }

    @Override
    public JSONObject getPersonal(String page, String rows, String filter) {

        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        result.put("errormsg", null);
        Map<String, Object> map = new HashMap<String, Object>();


        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("filter", filter);


        List<Personal> points = personalDao.findPersonal(map);
        Long total=personalDao.getTotalPersonal(map);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,
                new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        jsonArray = JSONArray.fromObject(points, jsonConfig);
        data.put("rows", jsonArray);
        data.put("total", total);
        result.put("data", data);
        return result;
    }
}
