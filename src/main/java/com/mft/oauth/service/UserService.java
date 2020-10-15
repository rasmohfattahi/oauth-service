package com.mft.oauth.service;

import com.mft.general.service.GenericService;
import com.mft.oauth.entities.User;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {

	Optional<User> findByUsername(String username);
}
