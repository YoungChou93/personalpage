package com.personal.dao;

import com.personal.entity.VisitRecord;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class VisitRecordDaoImpl implements VisitRecordDao {

    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public VisitRecord selectByPrimaryKey(String id) {
        return sessionTemplate.selectOne( "com.personal.dao.VisitRecordDao.selectByPrimaryKey", id);
    }

    @Override
    public VisitRecord selectByMap(Map<String, Object> map) {
        return sessionTemplate.selectOne( "com.personal.dao.VisitRecordDao.selectByMap", map);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sessionTemplate.delete( "com.personal.dao.VisitRecordDao.deleteByPrimaryKey", id);
    }

    @Override
    public int insertSelective(VisitRecord record) {
        return sessionTemplate.insert( "com.personal.dao.VisitRecordDao.insertSelective", record);
    }

    @Override
    public int updateByPrimaryKeySelective(VisitRecord record) {
        return sessionTemplate.update( "com.personal.dao.VisitRecordDao.updateByPrimaryKeySelective", record);
    }

    @Override
    public List<VisitRecord> findVisitRecord(Map<String, Object> map) {
        return sessionTemplate.selectList( "com.personal.dao.VisitRecordDao.findVisitRecord", map);
    }

    @Override
    public Long getTotalVisitRecord(Map<String, Object> map) {
        return sessionTemplate.selectOne( "com.personal.dao.VisitRecordDao.getTotalVisitRecord", map);
    }

    @Override
    public String getMaxID(Map<String, Object> map) {
        return sessionTemplate.selectOne( "com.personal.dao.VisitRecordDao.getMaxID", map);
    }
}
