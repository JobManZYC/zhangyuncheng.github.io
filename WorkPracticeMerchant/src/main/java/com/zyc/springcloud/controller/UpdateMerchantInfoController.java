package com.zyc.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyc.springcloud.service.SelectMerchantInfo;
import com.zyc.springcloud.service.UpdateMerchantInfoService;


@RestController
public class UpdateMerchantInfoController {

	@Autowired
	private UpdateMerchantInfoService updateMerchantInfoService;
	@Autowired
	private SelectMerchantInfo selectMerchantInfo;

	@RequestMapping(value="/updatemerchantinfo",method=RequestMethod.POST)
	public Map<String,String> UpdateMerchantInfo(@RequestParam("merchant")String merchant,@RequestParam("commodity")String commodity,@RequestParam("number")Integer number) {
		
		// 获取商品单价
		float price=selectMerchantInfo.getCommodityPrice(merchant, commodity);
		// 计算总价
		float totalPrice=number * price;
		// 修改商家的信息
		boolean result=selectMerchantInfo.UpdateMerchant(merchant, commodity, price, number, totalPrice);	
		
		Map<String,String> merchantMap=new HashMap<String,String>();
		merchantMap.put("result", String.valueOf(result));
		merchantMap.put("price",String.valueOf(price));
		merchantMap.put("totalPrice", String.valueOf(totalPrice));
		return merchantMap;
	}
	
	@RequestMapping("/says")
	public String Say() {
	//	return updateMerchantInfoService.Say();
		return null;
	}
	@RequestMapping("/getprice")
	public String getPri() {
		float res=selectMerchantInfo.getCommodityPrice("腾讯", "LOL");
		return String.valueOf(res);
	}
}
