package com.zyc.springcloud.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyc.springcloud.jwtfilter.JWTUtil;
import com.zyc.springcloud.service.LoginService;
import com.zyc.springcloud.service.RegisterService;


@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	StringRedisTemplate redisTemplate; 
	
	// 用户登录
	@RequestMapping(value = "/mains",method=RequestMethod.POST)
	private ModelAndView Login(HttpServletResponse response,@RequestParam("username") String username,@RequestParam("password") String password) {
		
		boolean result=loginService.getpassWorld(username,password);
		if(result) {
			// 生成一个token
			String token=JWTUtil.createToken(username);
			// 将用户信息存入cookie
			Cookie cookie=new Cookie("username",username);
			response.addCookie(cookie);
			ModelAndView mav=new ModelAndView();
			// String url=template.getForObject("http://merchant-eurake/getallcommodity", String.class);			
			 mav.setViewName("redirect:/allinfo");
			return mav;
		}else {
			return new ModelAndView("redirect:/login");
		}		
	}
	
	// 用户注册
	@RequestMapping(value = "/registers")
	private ModelAndView Register(HttpServletRequest request,HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repeatpassword=request.getParameter("repeatpassword");
		float money=Float.parseFloat(request.getParameter("money"));
		boolean result=registerService.instUser(username, password, repeatpassword, money);		
		if(result) {
			ModelAndView mav=new ModelAndView();
			mav.setViewName("login");
			return mav;
		}else {
			return new ModelAndView("redirect:/register");
		}		
	}
}
