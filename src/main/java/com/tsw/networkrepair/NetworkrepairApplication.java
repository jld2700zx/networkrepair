package com.tsw.networkrepair;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.tsw.networkrepair.**.dao"})
public class NetworkrepairApplication  {
	public static void main(String[] args){
		SpringApplication.run(NetworkrepairApplication.class, args);
	}

}
