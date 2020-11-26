package com.mahsoly.app.user.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.mahsoly.app.common.domain.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Role extends AbstractEntity{

	private String name;

	@ManyToMany
	@JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Permission> permissions;

}
