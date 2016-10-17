package com.personal.dao;

import com.personal.entity.VisitTotal;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class VisitTotalDaoImpl implements VisitTotalDao{

    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public VisitTotal selectByPrimaryKey(String id) {
        return sessionTemplate.selectOne( "com.personal.dao.VisitTotalDao.selectByPrimaryKey", id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sessionTemplate.delete( "com.personal.dao.VisitTotalDao.deleteByPrimaryKey", id);
    }

    @Override
    public int insertSelective(VisitTotal record) {
        return sessionTemplate.insert( "com.personal.dao.VisitTotalDao.insertSelective", record);
    }

    @Override
    public int updateByPrimaryKeySelective(VisitTotal record) {
        return sessionTemplate.update( "com.personal.dao.VisitTotalDao.updateByPrimaryKeySelective", record);
    }

    @Override
    public List<VisitTotal> findVisitTotal(Map<String, Object> map) {
        return sessionTemplate.selectList( "com.personal.dao.VisitTotalDao.findVisitTotal", map);
    }

    @Override
    public Long getTotalVisitTotal(Map<String, Object> map) {
        return sessionTemplate.selectOne( "com.personal.dao.VisitTotalDao.getTotalVisitTotal", map);
    }
}
