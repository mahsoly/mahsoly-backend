package com.mahsoly.app.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.mahsoly.app.domain.Category;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

}