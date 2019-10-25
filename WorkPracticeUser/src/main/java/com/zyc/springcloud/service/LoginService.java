package com.zyc.springcloud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import com.zyc.springcloud.mapper.UserMapper;

@Service
public class LoginService {
	@Autowired
	private UserMapper userMapper;
	
	// 登录
	public boolean getpassWorld(String username,String password) {
		String passwords=userMapper.getPassword(username);
		Map<String,Object> message=new HashMap<>();
		if(username==""||password=="") {
			message.put("msg","用户名或密码不能为空");
			System.out.println(message);
			return  false;
		}else if(!passwords.equals(password)){
			message.put("msg","用户名或密码错误");
			System.out.println(message);
			return  false;
		}else {
			return true;
		}		
	}
	
	

}
