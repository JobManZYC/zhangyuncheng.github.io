package com.zyc.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyc.springcloud.entity.OrderInfo;
import com.zyc.springcloud.service.GetOrderService;



@RestController
public class OrderController {

	@Autowired
	private GetOrderService getOrderService;
	
	
	@RequestMapping(value="/getorder",method=RequestMethod.POST)
	public boolean getOrder(@RequestParam("username") String username,
			@RequestParam("merchant") String merchant,
			@RequestParam("commodity")String commodity,
			@RequestParam("price") float price,
			@RequestParam("number") int number,
			@RequestParam("totalPrice") float totalprice) {
		OrderInfo orderInfo=null;
		boolean orderResult=getOrderService.getOrderService(username,merchant,commodity,price,number,totalprice);
		return orderResult;
	}
}
