package com.mahsoly.app.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mahsoly.app.common.utils.Utils;
import com.mahsoly.app.user.repo.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	final private UserRepository userRepository;

	@Override
	public Mono<UserDetails> findByUsername(String username) {
		return Utils.getMonoBlockingCall(() -> userRepository.findByUsername(username));
		// TODO:6-Continue with SecurityConfiguration required features
	}

}
