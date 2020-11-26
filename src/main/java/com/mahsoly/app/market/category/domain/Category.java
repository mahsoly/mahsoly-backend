package com.mahsoly.app.market.category.domain;

import javax.persistence.Entity;

import com.mahsoly.app.common.domain.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstractEntity{
	private String name;
	private String type;
}
