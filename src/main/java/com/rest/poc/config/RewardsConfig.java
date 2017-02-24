package com.rest.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
@ComponentScan(basePackages={"properties"})
@PropertySource(value = "classpath:com/rest/properties/rewards.properties")
public class RewardsConfig {
	static MongoClient client;
	static MongoDbFactory factory;
	static MongoTemplate template;
	
	@Autowired
	private Environment env;
	
	MongoDbFactory mongoDbFactory() throws Exception {
		String host = env.getProperty("local.mongodb.host");
		String port = env.getProperty("local.mongodb.port");
		String database = env.getProperty("local.mongodb.db");
		MongoClientOptions options = new MongoClientOptions.Builder().connectionsPerHost(10).build();
		MongoClient client = new MongoClient(new ServerAddress(host,Integer.parseInt(port)), options);
		factory = new SimpleMongoDbFactory(client, database);
		return factory;
	}
 
	@Bean
	MongoTemplate mongoTemplate() throws Exception {
		if(template == null){
			template = new MongoTemplate(mongoDbFactory());
		}
		return template;
	}	
}
