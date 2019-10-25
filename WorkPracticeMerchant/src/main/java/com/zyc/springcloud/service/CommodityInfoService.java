package com.zyc.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.springcloud.entity.CommodityInfo;
import com.zyc.springcloud.mapper.MerchantMapper;

@Service
public class CommodityInfoService {

	@Autowired
	private MerchantMapper merchantMapper;
	
	public List<CommodityInfo> getAllCommodityInfoService(){
		List<CommodityInfo> list=merchantMapper.getAllCommodities();
		return list;
	}
}
