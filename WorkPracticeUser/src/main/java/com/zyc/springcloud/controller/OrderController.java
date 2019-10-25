package com.zyc.springcloud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyc.springcloud.entity.OrderInfo;
import com.zyc.springcloud.service.MerchantService;
import com.zyc.springcloud.service.OrderService;
import com.zyc.springcloud.service.UpdateUserMoney;

import sun.util.logging.resources.logging;




@RestController
//@RequestMapping(value="/user")
public class OrderController {
	
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private UpdateUserMoney udpateUserMoney;
	@Autowired
	private OrderService orderService;
	
	// 生成订单
	@RequestMapping(value = "/getupdatemerchantinfo" ,method=RequestMethod.POST)
	public Map<String,String> ByCommodity(HttpServletRequest request,@RequestParam("merchant")String merchant,@RequestParam("commodity")String commodity,@RequestParam("number")Integer number) {

		Map<String,String> merchantMap=new HashMap<String,String>();
		// 修改商家信息
		merchantMap=merchantService.getMerchantUpdate(merchant,commodity,number);		
		// 获取购买商品的总价
		float totalPrice=Float.parseFloat(merchantMap.get("totalPrice"));
		// 获取商品的单价
		float price=Float.parseFloat(merchantMap.get("price"));
		// 获取用户名
		String username=null;
		Cookie cookie[]=request.getCookies();
		for(Cookie ck:cookie) {
			if(ck.getName().equals("username")) {
				username=ck.getValue();
			}
		}
		// 修改用户信息
		boolean userResult=udpateUserMoney.UpdateUserMoneyInfoService(username,totalPrice);		
		System.out.println(userResult);
		
		// 生成订单
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setUsername(username);
		orderInfo.setMerchant(merchant);
		orderInfo.setCommodity(commodity);
		orderInfo.setPrice(price);
		orderInfo.setNumber(number);
		orderInfo.setTotalprice(totalPrice);
		
		boolean orderResult=orderService.getOrderService(username,merchant,commodity,price,number,totalPrice);
		System.out.println(orderResult);
		
		// 获取当前时间 去掉后面的时分秒
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String s=sdf.format(date);
		try {
			Date date1=sdf.parse(s);
			
//			System.out.println(String.valueOf(date1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return merchantMap;
	}

	@RequestMapping("/say")
	public String Say() {
		return "666";
	}
}
