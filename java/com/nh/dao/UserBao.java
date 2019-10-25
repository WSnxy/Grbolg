package com.nh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nh.pojo.User;
@Repository
public interface UserBao extends JpaRepository<User,String>, JpaSpecificationExecutor<User>{
	
}
