package com.personal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public interface IndexService {

    public Map<String,Object> visitIndex(String ipaddr,String seaaionid);
}
