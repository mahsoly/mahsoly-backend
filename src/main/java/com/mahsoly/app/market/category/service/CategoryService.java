package com.mahsoly.app.market.category.service;


import com.mahsoly.app.market.category.domain.Category;

import reactor.core.publisher.Flux;


public interface CategoryService {
	
	Flux<Category> getCategories();

}
