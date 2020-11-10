package com.mahsoly.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.mahsoly.app.api.CategoryApi;
import com.mahsoly.app.model.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController implements CategoryApi {

	@Override
	public Mono<ResponseEntity<Flux<Category>>> getCategories(ServerWebExchange exchange) {
		Mono<ResponseEntity<Flux<Category>>> result = Mono.just(ResponseEntity.ok((Flux.just(new Category().type("V")))));
		return result;
	}
}
