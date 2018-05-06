package com.qiushui.joyotimes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.qiushui.joyotimes.domain.dao.SystemConfigRepository;

@SpringBootApplication
@EnableTransactionManagement
public class JoyotimesApplication {
	@Autowired
	SystemConfigRepository systemConfigRepository;
	public static void main(String[] args) {
		SpringApplication.run(JoyotimesApplication.class, args);
		
	}
}
