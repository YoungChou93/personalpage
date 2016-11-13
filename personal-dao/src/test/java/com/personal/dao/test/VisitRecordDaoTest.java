package com.personal.dao.test;

import com.personal.dao.UserDao;
import com.personal.dao.VisitRecordDao;
import com.personal.entity.VisitRecord;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class VisitRecordDaoTest {
    private ApplicationContext ctx = null;
    private VisitRecordDao visitRecordDao = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        visitRecordDao = ctx.getBean(VisitRecordDao.class);
    }

    @Test
    public void test(){
        /*VisitRecord  visitRecord=new VisitRecord();
        visitRecord.setId("1");
        visitRecord.setIpaddr("192.168.2.1");
        visitRecord.setDate(new Date());
        System.out.println(visitRecordDao.insertSelective(visitRecord));*/
        VisitRecord  visitRecord=new VisitRecord();
        visitRecord.setId("1");
        visitRecord.setIpaddr("192.168.2.1");


    }
}
