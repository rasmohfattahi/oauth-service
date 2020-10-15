package com.mft.oauth.service.imp;

import com.mft.general.service.imp.GenericServiceDefault;
import com.mft.oauth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mft.oauth.dao.UserRepository;
import com.mft.oauth.service.IUserService;

import java.util.Optional;

@Service
public class UserService extends GenericServiceDefault<User, Long> implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected JpaRepository<User, Long> getGenericRepo() {
		return userRepository;
	}

	@Override
	public Optional<User> findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

}
