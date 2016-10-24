package com.personal.dao;

import com.personal.entity.HeadPicture;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public interface HeadPictureDao {
    HeadPicture selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(HeadPicture record);

    int updateByPrimaryKeySelective(HeadPicture record);

    List<HeadPicture> findHeadPicture(Map<String, Object> map);

    Long getTotalHeadPicture(Map<String, Object> map);
}
