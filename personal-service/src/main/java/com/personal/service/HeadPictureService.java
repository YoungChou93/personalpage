package com.personal.service;

import com.personal.entity.HeadPicture;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2016/10/16.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/16
 */
public interface HeadPictureService {

    public JSONObject getHeadPicture(String page,String rows,String filter);

    public void enable(Integer id);

    public void disable(Integer id);

    public void addHeadPicture(HeadPicture headPicture, MultipartFile photo, String path) throws IOException;

    public void deleteHeadPicture(Integer id,String path);
}
