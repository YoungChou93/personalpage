package com.personal.dao;

import com.personal.entity.VisitTotal;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public interface VisitTotalDao {
    VisitTotal selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int insertSelective(VisitTotal record);

    int updateByPrimaryKeySelective(VisitTotal record);

    List<VisitTotal> findVisitTotal(Map<String, Object> map);

    Long getTotalVisitTotal(Map<String, Object> map);

}
