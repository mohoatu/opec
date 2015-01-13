package org.opec.xnk.service;

import org.opec.xnk.model.User;
import org.opec.xnk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}
}
