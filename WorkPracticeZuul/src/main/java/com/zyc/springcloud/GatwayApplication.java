package com.zyc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.zyc.springcloud.filter.MyFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class GatwayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatwayApplication.class, args);
	}

//	@Bean
//	public MyFilter tokenFilter() {
//		return new MyFilter();
//	}
}
