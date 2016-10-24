package com.personal.service;

import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2016/10/18.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/18
 */
public interface VisitTotalService {

    public JSONObject getVisitTotal(String page, String rows, String filter);
}
