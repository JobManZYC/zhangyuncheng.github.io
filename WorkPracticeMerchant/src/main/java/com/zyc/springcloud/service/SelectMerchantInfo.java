package com.zyc.springcloud.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyc.springcloud.mapper.MerchantMapper;

@Service
public class SelectMerchantInfo {

	@Autowired
	private MerchantMapper merchantMapper;
	
	public float getCommodityPrice(String merchant,String commodity) {
		float price= merchantMapper.getPrice(merchant, commodity);
		return price;
	}	
	// 修改商家信息 
	public boolean UpdateMerchant(String merchant,String commodity,float price,int number,float totalPrice) {
		boolean result=merchantMapper.UpdateMerchantInfo(merchant, commodity, price, number, totalPrice);
		return result;
	}
}
