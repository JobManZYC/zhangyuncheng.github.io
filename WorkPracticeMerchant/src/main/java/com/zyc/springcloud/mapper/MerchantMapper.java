package com.zyc.springcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.zyc.springcloud.entity.CommodityInfo;
import com.zyc.springcloud.entity.MerchantInfo;

@Mapper
public interface MerchantMapper    {	
	// 获取所有商品
	List<CommodityInfo> getAllCommodities();
	//获取所有商家信息
	List<MerchantInfo> getAllMerchantInfo();
	// 获取商品价格
	float getPrice(@Param("merchant") String merchant, @Param("commodity") String commodity);
	// 修改商家的信息
	boolean UpdateMerchantInfo(@Param("merchant")String merchant,@Param("commodity")String commodity,@Param("price")float price,@Param("number") int number,@Param("totalPrice")float totalPrice);
	
	
	
	
//	
//	// 购买商品
//	boolean buyCommodity(@Param("merchant") String merchant, @Param("commodity") String commodity,
//			@Param("number") int number,@Param("username") String username);
//
//	// 获取商品的数量
//	int getNumber(@Param("merchant") String merchant,@Param("commodity") String commodity);
//
//	float getUserPrice(String username);
//	
//	// 生成订单
//	boolean getOrder(@Param("username") String username, @Param("merchant") String merchant,
//			@Param("commodity") String commodity,@Param("price") float price,
//			@Param("number") int number,@Param("totalprice") float totalprice);
	

	
}
