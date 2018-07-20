package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * Demo class
 *
 * @author zhangyuhang
 * @date 2018/7/16
 */
public interface SuccessKilledDao {

    /** 
    * 插入购买明细，可过滤重复
    * @param seckillId
    * @param userPhone
    * @return int 
    */ 
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /** 
    * 根据id查询SuccessKilled并携带秒杀产品对象实体类
    * @param seckillId
    * @return org.seckill.entity.SuccessKilled
    */ 
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
