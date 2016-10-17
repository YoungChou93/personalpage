package com.personal.service;

import net.sf.json.JSONObject;

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
}
