package com.zyc.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.springcloud.entity.MerchantInfo;
import com.zyc.springcloud.mapper.MerchantMapper;

@Service
public class MerchantInfoService {

	@Autowired
	private MerchantMapper merchantMapper;	
	//获取所有商家信息
	public List<MerchantInfo> getAllMerchantInfoService() {
		List<MerchantInfo> list=merchantMapper.getAllMerchantInfo();
		return list;
	}
}
