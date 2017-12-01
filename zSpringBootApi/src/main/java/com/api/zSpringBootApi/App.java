package com.api.zSpringBootApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
(exclude = { DataSourceAutoConfiguration.class }) 
@PropertySource({"classpath:config.properties"})
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
