package com.shenghe;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
@EnableEurekaServer
public class StartApplication {

	public static void main(String[] args) {
		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		new SpringApplicationBuilder(StartApplication.class).resourceLoader(classPathXmlApplicationContext).web(true).run(args);
	}


}
