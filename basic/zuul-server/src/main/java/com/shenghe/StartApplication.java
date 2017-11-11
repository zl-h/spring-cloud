package com.shenghe;
/**
 *
 * @author Gunnar Hillert
 *
 */
import com.shenghe.server.zuul.AccessFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Configuration
//@ImportResource("classpath:applicationContext.xml")
@EnableZuulProxy
@SpringCloudApplication
@EnableAutoConfiguration
@Configurable
public class StartApplication {

	public static void main(String[] args) {
		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		new SpringApplicationBuilder(StartApplication.class).resourceLoader(classPathXmlApplicationContext).web(true).run(args);
//		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@Bean
	@Order(Integer.MAX_VALUE)
	public org.springframework.web.filter.CorsFilter corsFilter() {
		System.out.println("允许跨域请求");
		final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new org.springframework.web.filter.CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
