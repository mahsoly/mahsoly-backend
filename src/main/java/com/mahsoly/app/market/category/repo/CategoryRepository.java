package com.mahsoly.app.market.category.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mahsoly.app.market.category.domain.Category;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

}