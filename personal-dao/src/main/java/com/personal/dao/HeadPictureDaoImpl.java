package com.personal.dao;

import com.personal.entity.HeadPicture;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class HeadPictureDaoImpl implements HeadPictureDao {

    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public HeadPicture selectByPrimaryKey(String id) {
        return sessionTemplate.selectOne( "com.personal.dao.HeadPictureDao.selectByPrimaryKey", id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sessionTemplate.delete( "com.personal.dao.HeadPictureDao.deleteByPrimaryKey", id);
    }

    @Override
    public int insertSelective(HeadPicture record) {
        return sessionTemplate.insert( "com.personal.dao.HeadPictureDao.insertSelective", record);
    }

    @Override
    public int updateByPrimaryKeySelective(HeadPicture record) {
        return sessionTemplate.update( "com.personal.dao.HeadPictureDao.updateByPrimaryKeySelective", record);
    }

    @Override
    public List<HeadPicture> findHeadPicture(Map<String, Object> map) {
        return sessionTemplate.selectList( "com.personal.dao.HeadPictureDao.findHeadPicture", map);
    }

    @Override
    public Long getTotalHeadPicture(Map<String, Object> map) {
        return sessionTemplate.selectOne( "com.personal.dao.HeadPictureDao.getTotalHeadPicture", map);
    }
}
