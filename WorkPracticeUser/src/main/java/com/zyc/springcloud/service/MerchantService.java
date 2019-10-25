package com.zyc.springcloud.service;
import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zyc.springcloud.entity.CommodityInfo;
import com.zyc.springcloud.entity.MerchantInfo;

@FeignClient(value="merchant-eureka")
@Service
public interface MerchantService {
	// 获取所有商品信息
	@RequestMapping(value="/getallcommodityinfo")
	public List<CommodityInfo> getCommodity();
	
	// 获取所有商家信息
	@RequestMapping(value="/getallmerchantinfo")
	public List<MerchantInfo> getAllMerchantInfo();
	
	// 购买商品获取商家返回的信息
	@RequestMapping(value="/updatemerchantinfo",method=RequestMethod.POST)
	public Map<String,String> getMerchantUpdate(@RequestParam("merchant")String merchant,@RequestParam("commodity")String commodity,@RequestParam("number")Integer number);
}
