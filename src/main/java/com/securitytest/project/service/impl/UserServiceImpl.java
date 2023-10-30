package com.securitytest.project.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.securitytest.project.entity.MainEntity;
import com.securitytest.project.repository.UserRepo;
import com.securitytest.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public List<MainEntity> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public MainEntity saveUser(MainEntity user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public MainEntity updateUser(Long userId, MainEntity updateuser) {
		// TODO Auto-generated method stub
		Optional<MainEntity> optionalUser = userRepo.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new RuntimeException("User Not Found");
		}

		MainEntity existingUser = optionalUser.get();

		if (updateuser.getName() != null) {
			existingUser.setName(updateuser.getName());
		}

		if (updateuser.getEmail() != null) {
			existingUser.setEmail(updateuser.getEmail());
		}

		if (updateuser.getRole() != null) {
			existingUser.setRole(updateuser.getRole());
		}

		existingUser.setUpdatedAt(LocalDateTime.now());

		return userRepo.save(existingUser);
	}

	@Override
	public MainEntity deleteUser(Long userId) {
		// TODO Auto-generated method stub
		Optional<MainEntity> optionalUser = userRepo.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new RuntimeException("User Not Found");
		}
		MainEntity deletedUser = optionalUser.get();

		userRepo.deleteById(userId);
		return deletedUser;
	}

}
