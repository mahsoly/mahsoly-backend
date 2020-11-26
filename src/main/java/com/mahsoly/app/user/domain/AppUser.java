package com.mahsoly.app.user.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mahsoly.app.common.domain.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class AppUser extends AbstractEntity implements UserDetails {
	
	private static final long serialVersionUID = -1796337433883055332L;
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String mobileNumber;

	@ManyToOne
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role.getPermissions();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
