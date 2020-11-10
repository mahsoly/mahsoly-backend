package com.mahsoly.app.service;


import com.mahsoly.app.domain.Category;
import reactor.core.publisher.Flux;


public interface CategoryService {
	
	Flux<Category> getCategories();

}
