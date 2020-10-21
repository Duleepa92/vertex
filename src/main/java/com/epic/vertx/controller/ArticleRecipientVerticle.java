/**
 * 
 */
package com.epic.vertx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epic.vertx.service.ArticleRecipientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;

/**
 * @author duleepa_w
 *
 */
@Component
public class ArticleRecipientVerticle extends AbstractVerticle{
	
	 public static final String GET_ALL_ARTICLES = "get.articles.all";

	    private final ObjectMapper mapper = Json.mapper;

	    @Autowired
	    private ArticleRecipientService articleService;

	    private Handler<Message<String>> getAllArticleService(ArticleRecipientService service) {
	        return msg -> vertx.<String>executeBlocking(future -> {
	            try {
	                future.complete(mapper.writeValueAsString(service.test()));
	            } catch (JsonProcessingException e) {
	                System.out.println("Failed to serialize result");
	                future.fail(e);
	            }
	        }, result -> {
	            if (result.succeeded()) {
	                msg.reply(result.result());
	            } else {
	                msg.reply(result.cause()
	                        .toString());
	            }
	        });
	    }	
	    
	    
	    @Override
	    public void start() throws Exception {
	        super.start();
	        vertx.eventBus()
	                .<String>consumer(GET_ALL_ARTICLES)
	                .handler(getAllArticleService(articleService));
	    }

}
