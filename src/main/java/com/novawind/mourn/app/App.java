package com.novawind.mourn.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-27 16:21:34
*/
@SpringBootApplication(scanBasePackages = {"com.novawind.mourn"})
@EnableTransactionManagement
@EnableCaching
@PropertySource("classpath:application.yml")
public class App {
	private static volatile boolean running = true;
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		app.run(args);
		logger.info("Mourn App start successfully!");

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			synchronized (App.class) {
				running = false;
				App.class.notify();
				logger.info("Mourn App intend to be stopped!");
			}
        }));

		synchronized (App.class) {
			while(running){
				try {
					App.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		logger.info("Mourn App stop successfully!");

	}

	
}

