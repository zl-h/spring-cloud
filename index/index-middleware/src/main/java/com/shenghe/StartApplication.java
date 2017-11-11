package com.shenghe;

import com.alibaba.fastjson.JSON;
import com.shenghe.index.middleware.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzhili
 * @since 20170818
 * 由于Spring Boot会自动扫描@SpringBootApplication所在类的同级包（如com.hjf.boot.demo.boot_mybatis）以及下级包里的所有bean
 * 如果因为更改包名导致应用无法加载的情况，考虑手动scnan所在的包名即可
 */
//@ComponentScan(value = "com.shenghe")
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
@SpringBootApplication
public class StartApplication {

	static Logger logger = LoggerFactory.getLogger(StartApplication.class);

	@Autowired
	UserService userService;

	@RequestMapping("/hello")
	public String home() {
		logger.info("---------------------------------");
		logger.info("---------------------------------");
		logger.info("---------------------------------");
		logger.info("---------------------------------");
		logger.info("---------------------------------");
		logger.info("---------------------------------");
		logger.info("---------------------------------");
		return "Hello world";
	}

	public static void
	main(String[] args) {
		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		new SpringApplicationBuilder(StartApplication.class).resourceLoader(classPathXmlApplicationContext).web(true).run(args);
	}

}