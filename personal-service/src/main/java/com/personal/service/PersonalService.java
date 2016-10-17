package com.personal.service;

import com.personal.entity.Personal;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2016/10/16.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/16
 */
public interface PersonalService {

    public void addPersonalService(Personal personal,MultipartFile photo,String path) throws IOException;

    public void deletePersonalService(Integer id,String path);

    public void enable(Integer id);

    public void disable(Integer id);

    public JSONObject getPersonal(String page,String rows,String filter);

}
