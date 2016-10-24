package com.personal.controller;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/10/18.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/18
 */
public class ClientIPUtils {
    public static String getClientIp(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        //String ip = request.getHeader("X-real-ip");

        //logger.debug("x-forwarded-for = {}", ip);
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            //logger.debug("Proxy-Client-IP = {}", ip);
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            //logger.debug("WL-Proxy-Client-IP = {}", ip);
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            //logger.debug("RemoteAddr-IP = {}", ip);
        }
        if(StringUtils.isNotBlank(ip)) {
            ip = ip.split(",")[0];
        }
        return ip;

    }

}
