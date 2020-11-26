package com.mahsoly.app.user.repo;



import org.springframework.data.repository.CrudRepository;

import com.mahsoly.app.user.domain.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUsername(String username);
}