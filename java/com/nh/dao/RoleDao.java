package com.nh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nh.pojo.Role;;

public interface RoleDao  extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Role>{

}
