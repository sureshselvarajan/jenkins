package com.securitytest.project.service;

import java.util.List;

import com.securitytest.project.entity.MainEntity;

public interface UserService {
	List<MainEntity> getAllUser();
	
	MainEntity saveUser(MainEntity user);
	
	MainEntity updateUser(Long userId,MainEntity updateuser);
	
	MainEntity deleteUser(Long userId);
}
