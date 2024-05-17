package com.scheduler.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(" FROM com.scheduler.demo.entity.User s where s.userName =:name and s.userPassword=:password ORDER BY s.userName LIMIT 1  ")
	Optional<User> findUserByNamePassword(@Param("name")String name ,@Param("password")String password );
	
}
