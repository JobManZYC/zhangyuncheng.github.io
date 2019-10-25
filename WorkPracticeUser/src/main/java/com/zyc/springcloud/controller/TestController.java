package com.zyc.springcloud.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.zyc.springcloud.entity.User;
import com.zyc.springcloud.mapper.UserMapper;
@RestController
public class TestController {

	@Autowired
	private UserMapper userMapper;

	@GetMapping(value="/login")
	public ModelAndView say() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/login");
		return mav;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView logins11(ServletRequest req,ServletResponse resp ) throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("register");
		return mav;
	}
	@GetMapping("/getalluser")
	public List<User> getAllUser(){
		List<User> list=new ArrayList<>();
		list=userMapper.getAllUser();
		return list;
	}
	
	@RequestMapping("/getusermoney")
	public float getUserMoney(@RequestParam("username")String username){
		float money=0;
		money=userMapper.getMoney(username);
		return money;
	}
	

}
