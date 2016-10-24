package com.personal.service;

import com.personal.dao.VisitTotalDao;
import com.personal.entity.VisitTotal;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/18.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/18
 */
public class VisitTotalServiceImpl implements VisitTotalService{

    private VisitTotalDao visitTotalDao;

    public void setVisitTotalDao(VisitTotalDao visitTotalDao) {
        this.visitTotalDao = visitTotalDao;
    }

    @Override
    public JSONObject getVisitTotal(String page, String rows, String filter) {
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();

        Map<String, Object> map = new HashMap<String, Object>();

        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("filter", filter);

        List<VisitTotal> visitTotals = visitTotalDao.findVisitTotal(map);
        Long total=visitTotalDao.getTotalVisitTotal(map);

        jsonArray = JSONArray.fromObject(visitTotals);
        data.put("rows", jsonArray);
        data.put("total", total);
        result.put("data", data);
        return result;
    }
}
