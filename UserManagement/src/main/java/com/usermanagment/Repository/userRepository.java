package com.usermanagment.Repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagment.Entity.UserEntity;


public interface userRepository extends JpaRepository<UserEntity, Serializable> {
	
	UserEntity findByEmail(String email);
	UserEntity findByEmailAndPassword(String email,String pwd);

}
