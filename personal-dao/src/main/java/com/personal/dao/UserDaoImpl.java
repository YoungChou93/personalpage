package com.personal.dao;

import java.util.List;
import java.util.Map;

import com.personal.entity.User;
import com.personal.entity.UserPart;
import org.mybatis.spring.SqlSessionTemplate;



public class UserDaoImpl implements UserDao {

	private SqlSessionTemplate sessionTemplate;

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	@Override
	public User selectByPrimaryKey(String uid) {
		return sessionTemplate.selectOne( "com.personal.dao.UserDao.selectByPrimaryKey", uid);
	}

	@Override
	public User selectByMap(Map<String, Object> map) {
		return sessionTemplate.selectOne( "com.personal.dao.UserDao.selectByMap", map);
	}

	@Override
	public int deleteByPrimaryKey(String uid) {
		return sessionTemplate.delete( "com.personal.dao.UserDao.deleteByPrimaryKey", uid);
	}

	@Override
	public int deleteByMap(Map<String, Object> map) {
		return sessionTemplate.delete( "com.personal.dao.UserDao.deleteByMap", map);
	}

	@Override
	public int insertSelective(User record) {
		return sessionTemplate.insert( "com.personal.dao.UserDao.insertSelective", record);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return sessionTemplate.update( "com.personal.dao.UserDao.updateByPrimaryKeySelective", record);
	}

	@Override
	public List<User> findUser(Map<String, Object> map) {
		return sessionTemplate.selectList( "com.personal.dao.UserDao.findUser", map);
	}

	@Override
	public Long getTotalUser(Map<String, Object> map) {
		return sessionTemplate.selectOne( "com.personal.dao.UserDao.getTotalUser", map);
	}

	@Override
	public String getMaxID(Map<String, Object> map) {
		return sessionTemplate.selectOne( "com.personal.dao.UserDao.getMaxID", map);
	}

	@Override
	public UserPart selectPartByPrimaryKey(String uid) {
		return sessionTemplate.selectOne( "com.personal.dao.UserDao.selectPartByPrimaryKey", uid);
	}

	@Override
	public UserPart selectPartByMap(Map<String, Object> map) {
		return sessionTemplate.selectOne( "com.personal.dao.UserDao.selectPartByMap", map);
	}

}
