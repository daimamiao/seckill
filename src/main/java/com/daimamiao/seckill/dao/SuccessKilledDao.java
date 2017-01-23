package com.daimamiao.seckill.dao;

import com.daimamiao.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xcc on 1/22/2017.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复，success_killed表中有个联合主键
     * PRIMARY KEY (seckill_id, user_phone)
     * @param seckillId
     * @param userPhone
     * @return 插入的结果集数量(行数)，0=>插入失败
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
