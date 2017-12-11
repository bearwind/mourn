package com.novawind.mourn.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-30 10:17:30
*/
@Configuration
@EnableJpaRepositories(basePackages = {"com.novawind.mourn.repository"})
@EntityScan(basePackages = {"com.novawind.mourn.entity"})
public class JpaConfig {

}

