	package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.config.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUserName(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
    User findByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

}
