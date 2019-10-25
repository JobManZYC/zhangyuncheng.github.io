package com.zyc.springcloud.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value="user-eureka")
public interface UpdateMerchantInfoService {
	
	@RequestMapping(value="/updatemerchantinfo" ,method=RequestMethod.POST)
	public Map<String,String> UpdateMerchantInfo(HttpSession session);
	@RequestMapping("/say")
	public String Say();
	
	
}
