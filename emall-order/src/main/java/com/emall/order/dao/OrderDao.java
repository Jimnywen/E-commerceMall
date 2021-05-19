package com.emall.order.dao;

import com.emall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jayden
 * @email jimnywen@gmail.com
 * @date 2021-01-05 19:31:10
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
