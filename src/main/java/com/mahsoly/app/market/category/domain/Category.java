package com.mahsoly.app.market.category.domain;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Table("category")
public class Category {
	@Id
	private Long id;
	private String name;
	private String type;
}
