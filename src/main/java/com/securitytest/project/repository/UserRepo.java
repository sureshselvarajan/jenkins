package com.securitytest.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitytest.project.entity.MainEntity;

public interface UserRepo extends JpaRepository<MainEntity, Long> {

	List<MainEntity> findAll();

}
