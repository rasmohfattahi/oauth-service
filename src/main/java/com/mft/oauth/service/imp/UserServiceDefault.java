package com.mft.oauth.service.imp;

import com.mft.general.service.imp.GenericServiceDefault;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mft.oauth.dao.UserRepository;
import com.mft.oauth.entities.User;
import com.mft.oauth.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceDefault extends GenericServiceDefault<User, Long> implements UserService {

	private final UserRepository userRepository;

	@Override
	protected JpaRepository<User, Long> getGenericRepo() {
		return userRepository;
	}

	@Override
	public Optional<User> findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

}
