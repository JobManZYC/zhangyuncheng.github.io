package com.zyc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyc.springcloud.entity.MerchantInfo;
import com.zyc.springcloud.service.MerchantInfoService;

@RestController
public class MerchantInfoController {

	@Autowired
	private MerchantInfoService merchantInfoService;
	@RequestMapping(value="/getallmerchantinfo",method=RequestMethod.GET)
	public List<MerchantInfo> getAllMerchantInfoController(){
		List<MerchantInfo> list=merchantInfoService.getAllMerchantInfoService();
		return list;
	}
}
