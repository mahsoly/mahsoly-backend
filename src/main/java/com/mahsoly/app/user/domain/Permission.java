package com.mahsoly.app.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Permission implements GrantedAuthority {

	private static final long serialVersionUID = 424912257309837104L;
	
	@Id
	private Long id;
	private String name;

	@Override
	public String getAuthority() {
		return name;
	}

}
