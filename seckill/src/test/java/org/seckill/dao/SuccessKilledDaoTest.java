package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Demo class
 *
 * @author zhangyuhang
 * @date 2018/7/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long myPhone = 18220509911L;
        int i = successKilledDao.insertSuccessKilled(1001L, myPhone);
        System.out.println(i);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long myPhone = 18220509911L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1001L, myPhone);
        System.out.println(successKilled);
        /*SuccessKilled{seckillId=1000, userPhone=18220509911, state=-1, createTime=Tue Jul 17 11:55:23 CST 2018, seckill=Seckill{seckillId=1000, name='100元秒杀iPhone8', number=100, startTime=Mon Jul 16 00:00:00 CST 2018, endTime=Tue Jul 17 00:00:00 CST 2018, createTime=Mon Jul 16 14:33:42 CST 2018}}*/
    }

}