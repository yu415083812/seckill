package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author zhangyuhang
 * @date 2018/7/16
 */
public interface SeckillDao {
    
    /** 
    * 减库存
    * @param seckillId
    * @param killTime
    * @return int 
    */ 
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /** 
    * 根据id查询秒杀对象
    * @param seckillId
    * @return org.seckill.entity.Seckill
    */ 
    Seckill queryById(long seckillId);

    /** 
    * 根据偏移量查询秒杀商品列表
    * @param offset
    * @param limit
    * @return java.util.List<org.seckill.entity.Seckill>
    */ 
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /** 
    * 使用存储过程执行秒杀
    * @param map
    * @return 
    */ 
    void killByProcedure(Map<String, Object> map);
}