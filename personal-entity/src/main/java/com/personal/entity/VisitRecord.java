package com.personal.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class VisitRecord {
    private String id;

    private String ipaddr;

    private String sessionid;

    private Date date;

    private String unused1;

    private String unused2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUnused1() {
        return unused1;
    }

    public void setUnused1(String unused1) {
        this.unused1 = unused1 == null ? null : unused1.trim();
    }

    public String getUnused2() {
        return unused2;
    }

    public void setUnused2(String unused2) {
        this.unused2 = unused2 == null ? null : unused2.trim();
    }
}
