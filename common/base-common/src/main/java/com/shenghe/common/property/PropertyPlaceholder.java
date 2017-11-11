package com.shenghe.common.property;

/**
 * @author huangzhili
 * @since 2017/7/2817:09
 */

import java.io.FileInputStream;
import java.net.URL;
import java.util.*;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Order(value = 0)
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

    }

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public PropertyPlaceholder(String[] propertyFileKeys) {

        List<Resource> resources = new ArrayList<Resource>();
        Properties properties = new Properties();
        for (String propertyFile : propertyFileKeys) {
            try {
                String configProperties = System.getProperty(propertyFile);
                if (configProperties.startsWith("/")) {
                    FileSystemResource fileSystemResource = new FileSystemResource(configProperties);
                    resources.add(fileSystemResource);
                    properties.load(new FileInputStream(fileSystemResource.getFile()));
//                    System.setProperties(new Properties(fileSystemResource.getFile()));
                } else {
                    UrlResource configResource = new UrlResource(new URL(configProperties));
                    properties.load(new FileInputStream(configResource.getFile()));
                    resources.add(configResource);

                }
            } catch (Exception e) {
                throw new BeanCreationException("failed to load properties file '" + propertyFile + "'", e);
            }
        }
        if (resources.size() > 0) {
            super.setLocations(resources.toArray(new Resource[resources.size()]));

            //设置系统变量
            Set<String> stringPropertyNames = properties.stringPropertyNames();
            for(String name : stringPropertyNames) {
                System.setProperty(name, properties.getProperty(name));
            }
        }
        logger.info("加载配置文件完成" + resources.size()
//                + JSON.toJSONString(System.getenv())
                + JSON.toJSONString(System.getProperties()));
    }
}
