package com.zyc.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyc.springcloud.entity.OrderInfo;

@Service
@FeignClient(value="order-eureka")
public interface OrderService {

	@RequestMapping(value="getorder" ,method=RequestMethod.POST)
	public boolean getOrderService(@RequestParam("username") String username,
			@RequestParam("merchant") String merchant,
			@RequestParam("commodity")String commodity,
			@RequestParam("price") float price,
			@RequestParam("number") int number,
			@RequestParam("totalPrice") float totalprice);
}
