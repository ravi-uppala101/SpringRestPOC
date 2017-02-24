package com.rest.poc.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.rest.poc.config.RewardsConfig;

@Component
public class RewardsUtils {
	public MongoOperations getMongoOperations(){
		  ApplicationContext ctx = new AnnotationConfigApplicationContext(RewardsConfig.class);
		  return (MongoOperations)ctx.getBean("mongoTemplate");
	}
}
