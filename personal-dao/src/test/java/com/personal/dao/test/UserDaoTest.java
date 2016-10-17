package com.personal.dao.test;

import com.personal.dao.UserDao;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/13.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/13
 */
public class UserDaoTest {

    private ApplicationContext ctx = null;
    private UserDao userDao = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        userDao = ctx.getBean(UserDao.class);
    }

    @Test
    public void test(){
        Map<String,Object> map=new HashMap<String,Object>();
        System.out.println(userDao.findUser(map));

    }
}
