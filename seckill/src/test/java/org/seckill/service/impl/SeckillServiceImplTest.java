package org.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Demo class
 *
 * @author zhangyuhang
 * @date 2018/7/18
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(SeckillServiceImplTest.class);

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000L);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long seckillId = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        logger.info("exposer={}", exposer);
        //exposed=true, md5='305d30c0d4ff82ffd6ff2d15cd8727c0', seckillId=1000
    }

    @Test
    public void executeSeckill() throws Exception {
        long seckillId = 1000L;
        long phone = 18220509911L;
        String md5 = "305d30c0d4ff82ffd6ff2d15cd8727c0";
//        try {
//            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
//            logger.info("seckillExecution={}", seckillExecution);
//        } catch (RepeatKillException e) {
//            logger.warn(e.getMessage());
//        } catch (SeckillCloseException e) {
//            logger.warn(e.getMessage());
//        }
    }

    @Test
    public void exportSeckill() throws Exception {
        long seckillId = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()){
            logger.info("exposer={}", exposer);
            long phone = 18220509912L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
                logger.info("seckillExecution={}", seckillExecution);
            } catch (RepeatKillException e) {
                logger.warn(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.warn(e.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
    }

}