package com.zyc.springcloud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.springcloud.entity.User;
import com.zyc.springcloud.entity.UserRegister;
import com.zyc.springcloud.mapper.UserMapper;

@Service
public class RegisterService {
	@Autowired
	private UserMapper userMapper;	

	public boolean instUser(String username,String password,String repeatpassword,float money) {		
		Map<String,Object> message=new HashMap<>();		
		UserRegister userRegister=new UserRegister();			
		List<User> userList=new ArrayList<>();
		userList=userMapper.getAllUser();
		for(User user:userList) {
			if(username.equals(user.getUsername())) {
				message.put("msg", "用户名已存在");
				System.out.println(message);
				return false;
			}
		}
		if(username==""||password=="") {
			message.put("msg", "用户名或密码不能为空");
			System.out.println(message);
			return false;
		}else if(!password.equals(repeatpassword)) {
			message.put("msg", "两次密码不相等");
			System.out.println(message);
			return false;
		}else if(money<0) {
			message.put("msg", "金额不能为负数");
			System.out.println(message);
			return false;
		}else {
			boolean result=userMapper.instUser(username,password,"user","normal","0",money);
			return result;
		}
	}
}
