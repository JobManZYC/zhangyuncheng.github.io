package com.zyc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.zyc.springcloud.mapper")
@EnableFeignClients
public class MerchantApplication {
	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args);
	}
}
