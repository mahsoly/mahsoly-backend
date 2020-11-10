package com.mahsoly.app.service;

import org.springframework.stereotype.Service;

import com.mahsoly.app.domain.Category;
import com.mahsoly.app.repo.CategoryRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	
	@Override
	public Flux<Category> getCategories() {
		return categoryRepository.findAll();
	}

}
