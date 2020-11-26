package com.mahsoly.app.market.category.repo;


import org.springframework.data.repository.CrudRepository;

import com.mahsoly.app.market.category.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}