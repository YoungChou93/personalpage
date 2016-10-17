package com.personal.entity;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class VisitTotal {
    private String id;

    private Integer number;

    private String unused1;

    private String unused12;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnused1() {
        return unused1;
    }

    public void setUnused1(String unused1) {
        this.unused1 = unused1 == null ? null : unused1.trim();
    }

    public String getUnused12() {
        return unused12;
    }

    public void setUnused12(String unused12) {
        this.unused12 = unused12 == null ? null : unused12.trim();
    }
}
