package com.zyc.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.springcloud.mapper.UserMapper;

@Service
public class UpdateUserMoney {

	@Autowired
	private UserMapper userMapper;	
	public boolean UpdateUserMoneyInfoService(String username,float totalPrice) {
		boolean result=userMapper.UpdateUserMoney(username, totalPrice);
		return result;
	}
}
