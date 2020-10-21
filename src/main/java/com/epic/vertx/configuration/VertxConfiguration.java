/**
 * 
 */
package com.epic.vertx.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.epic.vertx.controller.ArticleRecipientVerticle;
import com.epic.vertx.controller.VertxController;
import com.epic.vertx.model.User;

import io.vertx.core.Vertx;

/**
 * @author duleepa_w
 *
 */

@Configuration
public class VertxConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	@Autowired
    private VertxController serverVerticle;
 
    @Autowired
    private ArticleRecipientVerticle articleRecipientVerticle;
    
    @PostConstruct
    public void deployVerticle() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(serverVerticle);
        vertx.deployVerticle(articleRecipientVerticle);
    }
	
}
