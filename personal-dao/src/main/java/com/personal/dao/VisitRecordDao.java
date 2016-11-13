package com.personal.dao;

import com.personal.entity.VisitRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public interface VisitRecordDao {
    VisitRecord selectByPrimaryKey(String id);

    VisitRecord selectByMap(Map<String, Object> map);

    int deleteByPrimaryKey(String id);

    int insertSelective(VisitRecord record);

    int updateByPrimaryKeySelective(VisitRecord record);

    List<VisitRecord> findVisitRecord(Map<String, Object> map);

    Long getTotalVisitRecord(Map<String, Object> map);

    String getMaxID(Map<String, Object> map) ;

    Long getTotalNumber(Map<String, Object> map);
}
