package com.example.demo;

import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserModelReposistory extends JpaRepository<UserModel, Integer> {

	Optional<UserModel> findUserModelByusername(String username);
}
