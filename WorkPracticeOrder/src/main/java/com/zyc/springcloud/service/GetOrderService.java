package com.zyc.springcloud.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyc.springcloud.entity.OrderInfo;
import com.zyc.springcloud.mapper.MerchantMapper;
@Service
public class GetOrderService {

	@Autowired
	private MerchantMapper merchantMapper;

	public boolean getOrderService(@RequestParam("username") String username,
			@RequestParam("merchant") String merchant,
			@RequestParam("commodity")String commodity,
			@RequestParam("price") float price,
			@RequestParam("number") int number,
			@RequestParam("totalprice") float totalprice) {
		boolean result=merchantMapper.getOrderMapper(username,merchant,commodity,price,number,totalprice);
		return result;
	}
}



