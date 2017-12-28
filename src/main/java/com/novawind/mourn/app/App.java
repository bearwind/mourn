package com.novawind.mourn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-27 16:21:34
*/
@SpringBootApplication(scanBasePackages = {"com.novawind.mourn"})
@EnableTransactionManagement
@EnableCaching
public class App {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		app.run(args);
	}
	
	
}

