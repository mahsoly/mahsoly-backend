package com.mahsoly.app.market.category.service;


import org.springframework.stereotype.Service;

import com.mahsoly.app.common.utils.Utils;
import com.mahsoly.app.market.category.domain.Category;
import com.mahsoly.app.market.category.repo.CategoryRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Override
	public Flux<Category> getCategories() {
		return Utils.getFluxBlockingCall(()-> categoryRepository.findAll());
	}

}
