package com.zyc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zyc.springcloud.entity.CommodityInfo;
import com.zyc.springcloud.service.CommodityInfoService;

@RestController
public class CommodityInfoController {

	@Autowired
	private CommodityInfoService commodityInfoService;
	@RequestMapping(value="/getallcommodityinfo")
	public List<CommodityInfo> getAllCommodityInfoController(){
		List<CommodityInfo> list=commodityInfoService.getAllCommodityInfoService();
		return list;
	}
}
