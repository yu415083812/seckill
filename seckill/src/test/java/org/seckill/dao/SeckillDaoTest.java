package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，Junit启动时加载springIOC容器
 *spring-test, junit
 * @author zhangyuhang
 * @date 2018/7/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /*
        *100元秒杀iPhone8
        *Seckill{seckillId=1000, name='100元秒杀iPhone8', number=100, startTime=Mon Jul 16 00:00:00 CST 2018, endTime=Tue Jul 17 00:00:00 CST 2018, createTime=Mon Jul 16 14:33:42 CST 2018}
        */
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckillList
             ) {
            System.out.println(seckill);
        }
        /*
         * Seckill{seckillId=1000, name='100元秒杀iPhone8', number=100, startTime=Mon Jul 16 00:00:00 CST 2018, endTime=Tue Jul 17 00:00:00 CST 2018, createTime=Mon Jul 16 14:33:42 CST 2018}
         Seckill{seckillId=1001, name='500元秒杀iPad4', number=200, startTime=Mon Jul 16 00:00:00 CST 2018, endTime=Tue Jul 17 00:00:00 CST 2018, createTime=Mon Jul 16 14:33:42 CST 2018}
         Seckill{seckillId=1002, name='300元秒杀小米8', number=300, startTime=Mon Jul 16 00:00:00 CST 2018, endTime=Tue Jul 17 00:00:00 CST 2018, createTime=Mon Jul 16 14:33:42 CST 2018}
         Seckill{seckillId=1003, name='50元秒杀红米note4', number=400, startTime=Mon Jul 16 00:00:00 CST 2018, endTime=Tue Jul 17 00:00:00 CST 2018, createTime=Mon Jul 16 14:33:42 CST 2018}
         */
    }

    @Test
    public void reduceNumber() throws Exception {
        Date date = new Date();
        int i = seckillDao.reduceNumber(1000L, date);
        System.out.println(i);
    }

}