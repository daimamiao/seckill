package com.daimamiao.seckill.dao;

import com.daimamiao.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

import com.daimamiao.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xcc on 1/23/2017.
 */

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test, junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    // 注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {

        /**
         * java没有保存形参的记录
         * 编译时，List<Seckill> queryAll(int offset, int limit) => List<Seckill> queryAll(arg0, arg1);
         * 所以无法识别在SeckillDao.xml中使用的offset, limit
         */
        List<Seckill> seckills = seckillDao.queryAll(1, 2);
        for (Seckill seckill : seckills){
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println(updateCount);
    }
}