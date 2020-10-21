/**
 * 
 */
package com.epic.vertx.service;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.epic.vertx.model.User;
import com.epic.vertx.repository.UserRepository;

/**
 * @author duleepa_w
 *
 */
@SuppressWarnings("unused")
@Service
public class ArticleRecipientService implements UserRepository{

	
	private RedisTemplate<String, User> redisTemplate;

	@SuppressWarnings("rawtypes")
	private HashOperations hashOperations;

	public ArticleRecipientService(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("USER");
	}

	
	public String test() {
		return "Test by Duleepa";
	}
}
