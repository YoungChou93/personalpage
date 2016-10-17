package com.personal.dao;

import com.personal.entity.Personal;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public interface PersonalDao {

    Personal selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Personal record);

    int updateByPrimaryKeySelective(Personal record);

    List<Personal> findPersonal(Map<String, Object> map);

    Long getTotalPersonal(Map<String, Object> map);

}
