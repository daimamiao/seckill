package com.daimamiao.seckill.service;

import com.daimamiao.seckill.dto.Exposer;
import com.daimamiao.seckill.dto.SeckillExecution;
import com.daimamiao.seckill.entity.Seckill;
import com.daimamiao.seckill.exception.RepeatKillException;
import com.daimamiao.seckill.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xcc on 1/23/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
        /**
         * Exposer{exposed=true, md5='19e971f623661aaf15992b556a4524c3', seckillId=1000, now=0, start=0, end=0}
         */
    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000L;
        long phone = 18202732816L;
        String md5 = "19e971f623661aaf15992b556a4524c3";

//        try {
//            SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
//            logger.info("seckillExecution={}", seckillExecution);
//        } catch (RepeatKillException e) {
//            logger.error(e.getMessage());
//        } catch (SeckillCloseException e) {
//            logger.error(e.getMessage());
//        }
        /**
         * seckillExecution=SeckillExecution{
         * seckillId=1000, state=1, stateInfo='秒杀成功',
         * successKilled=SuccessKilled{seckillId=1000, userPhone=18202732816, state=0, createTime=Tue Jan 24 00:12:54 CST 2017}}
         */
    }

    /**
     * 集成测试代码完整逻辑
     * @throws Exception
     */
    @Test
    public void seckillLogic() throws Exception {
        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 18202732816L;
            String md5 = exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("seckillExecution={}", seckillExecution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
        /**
         * Exposer{exposed=true, md5='19e971f623661aaf15992b556a4524c3', seckillId=1000, now=0, start=0, end=0}
         */
    }

}