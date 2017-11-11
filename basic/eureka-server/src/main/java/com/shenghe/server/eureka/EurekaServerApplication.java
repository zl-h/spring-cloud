/*
package com.shenghe.server.eureka;

import com.shenghe.common.property.PropertyPlaceholder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.XmlEmbeddedWebApplicationContext;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

*/
/**
 *
 * @author Gunnar Hillert
 *
 *//*

//@ImportResource(locations = "classpath:applicationContext.xml")
//@Configuration
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) throws Exception {
		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		new SpringApplicationBuilder(EurekaServerApplication.class).resourceLoader(classPathXmlApplicationContext).web(true).run(args);
	}

}
*/
