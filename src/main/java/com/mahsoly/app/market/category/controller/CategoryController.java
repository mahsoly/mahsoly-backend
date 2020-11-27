package com.mahsoly.app.market.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.mahsoly.app.api.CategoryApi;
import com.mahsoly.app.market.category.service.CategoryService;
import com.mahsoly.app.model.CategoryDto;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class CategoryController implements CategoryApi {

	private final CategoryService categoryService;

	@Override
	@PreAuthorize("hasAuthority('CATEGORY')")
	public Mono<ResponseEntity<Flux<CategoryDto>>> getCategories(ServerWebExchange exchange) {
		Mono<ResponseEntity<Flux<CategoryDto>>> result = Mono.just(ResponseEntity.ok(categoryService.getCategories()
				.map(c -> (CategoryDto) new CategoryDto().name(c.getName()).type(c.getType()).id(c.getId()).isActive(true))));
		return result;
	}
}
