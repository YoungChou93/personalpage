package com.personal.dao;

import com.personal.entity.Personal;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class PersonalDaoImpl implements PersonalDao {

    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public Personal selectByPrimaryKey(Integer id) {
        return sessionTemplate.selectOne( "com.personal.dao.PersonalDao.selectByPrimaryKey", id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sessionTemplate.delete( "com.personal.dao.PersonalDao.deleteByPrimaryKey", id);
    }

    @Override
    public int insertSelective(Personal record) {
        return sessionTemplate.insert( "com.personal.dao.PersonalDao.insertSelective", record);
    }

    @Override
    public int updateByPrimaryKeySelective(Personal record) {
        return sessionTemplate.update( "com.personal.dao.PersonalDao.updateByPrimaryKeySelective", record);
    }

    @Override
    public List<Personal> findPersonal(Map<String, Object> map) {
        return sessionTemplate.selectList( "com.personal.dao.PersonalDao.findPersonal", map);
    }

    @Override
    public Long getTotalPersonal(Map<String, Object> map) {
        return sessionTemplate.selectOne( "com.personal.dao.PersonalDao.getTotalPersonal", map);
    }
}
