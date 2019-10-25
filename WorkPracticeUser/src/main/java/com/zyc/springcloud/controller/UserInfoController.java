package com.zyc.springcloud.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyc.springcloud.entity.User;
import com.zyc.springcloud.service.UserInfoService;

@RestController
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;	
	@RequestMapping(value="/getuserinfo",method = RequestMethod.GET)
	public ModelAndView getUserInfo(@CookieValue("username") String username,Model model) {
		User user=userInfoService.getUserInfo(username);
		model.addAttribute("userinfo", user);		
		return new ModelAndView("userinfo","userInfoModel",model);
	}
}
