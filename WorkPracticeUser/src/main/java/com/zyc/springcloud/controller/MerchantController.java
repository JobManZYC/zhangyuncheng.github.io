package com.zyc.springcloud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyc.springcloud.entity.CommodityInfo;
import com.zyc.springcloud.entity.MerchantInfo;
import com.zyc.springcloud.service.MerchantService;

@RestController
public class MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	@RequestMapping(value="/getallcommoditys")
	public List<CommodityInfo> getShow() {
		List<CommodityInfo> list=merchantService.getCommodity();
		return list;
	}
	
	@RequestMapping("/allinfo")
	public ModelAndView getAllInfo(Model model) {		
		model.addAttribute("allInfo", getShow());
		return new ModelAndView("main", "userModel", model);
	}
	
	@RequestMapping(value="/getallmerchantinfos",method=RequestMethod.GET)
	public ModelAndView getAllMerchantInfoController(Model model){
		List<MerchantInfo> merchantinfoList=merchantService.getAllMerchantInfo();
		model.addAttribute("merchantinfo", merchantinfoList);
		return new ModelAndView("merchantinfo","merchantInfoModel",model);
	}
}
