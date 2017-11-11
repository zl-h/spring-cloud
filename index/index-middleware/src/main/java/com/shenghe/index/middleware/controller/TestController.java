package com.shenghe.index.middleware.controller;

import com.alibaba.fastjson.JSON;
import com.shenghe.index.middleware.service.UserService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author huangzhili
 * @since 20170818
 * 由于Spring Boot会自动扫描@SpringBootApplication所在类的同级包（如com.hjf.boot.demo.boot_mybatis）以及下级包里的所有bean
 * 如果因为更改包名导致应用无法加载的情况，考虑手动scnan所在的包名即可
 */
@RestController
public class TestController {

	static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	UserService userService;

	@PostConstruct
	public void init(){
		logger.info("-----------------------init-------------------------");
	}

	@RequestMapping("/hello123")
	public String home() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(new DateTime().toDateTime());
//		stringBuilder.append(JSON.toJSONString(userService.findAll()));
//		logger.info(JSON.toJSONString(userService.findAll()) + "---------------------------------");
//		logger.info("---------------------------------");
//		logger.info("---------------------------------");
		return stringBuilder.toString();
	}

}