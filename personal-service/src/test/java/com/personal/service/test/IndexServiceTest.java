package com.personal.service.test;

import com.personal.service.IndexService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class IndexServiceTest {
    private ApplicationContext ctx = null;
    private IndexService indexService = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        indexService = ctx.getBean(IndexService.class);
    }

    @Test
    public void test(){

        indexService.visitIndex("1.1.1.1");

    }

}
