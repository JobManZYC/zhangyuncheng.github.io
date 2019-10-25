package com.zyc.springcloud.mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyc.springcloud.entity.OrderInfo;

@Repository
public interface MerchantMapper    {	
	
	// 生成订单
	boolean getOrderMapper(@Param("username") String username,
			@Param("merchant") String merchant,
			@Param("commodity")String commodity,
			@Param("price") float price,
			@Param("number") int number,
			@Param("totalprice") float totalprice);

}
