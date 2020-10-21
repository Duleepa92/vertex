/**
 * 
 */
package com.epic.vertx.repository;

import java.util.Map;

import com.epic.vertx.model.User;

/**
 * @author duleepa_w
 *
 */
public interface UserRepository {

	Map<String, User> findAll();
	
}
