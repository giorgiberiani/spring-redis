package com.springbootaplication.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class MainApplication {

	 @Bean
	JedisConnectionFactory jedisConnectionFactory() {
		 return new JedisConnectionFactory();
	 }

	 @Bean
	RedisTemplate<String, User> redisTemplate(){
	 	RedisTemplate<String, User> redisTemplate = new RedisTemplate<String, User>();
	 	redisTemplate.setConnectionFactory(jedisConnectionFactory());
	 	return redisTemplate;
	 }


	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}
}
