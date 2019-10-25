package com.zyc.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyc.springcloud.entity.User;
import com.zyc.springcloud.mapper.UserMapper;


@Service
public class UserInfoService {

	@Autowired
	private UserMapper userMapper;
	
	// 获取用户信息
	public User getUserInfo(String username) {
		User user=userMapper.getUserInfo(username);		
		return user;
	}
}
