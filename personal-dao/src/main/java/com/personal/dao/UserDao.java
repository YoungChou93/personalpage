package com.personal.dao;

import com.personal.entity.User;
import com.personal.entity.UserPart;

import java.util.List;
import java.util.Map;


public interface UserDao {

    User selectByPrimaryKey(String uid);
    
    User selectByMap(Map<String, Object> map);
    
    int deleteByPrimaryKey(String uid);
    
    int deleteByMap(Map<String, Object> map);
    
    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);
    
    List<User> findUser(Map<String, Object> map);
    
    Long getTotalUser(Map<String, Object> map);
    
    String getMaxID(Map<String, Object> map) ;
    
    UserPart selectPartByPrimaryKey(String uid);
    
    UserPart selectPartByMap(Map<String, Object> map);

}
