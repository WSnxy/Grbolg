package com.nh.service;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nh.dao.UserBao;
import com.nh.pojo.User;

@Service
public class UserService{
   @Autowired
    private UserBao userBao;
  //查询用户
   public User getUserByName(String username) {
	   Specification<User> spec = new Specification<User>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			Path<Object> name = root.get("username");
			return criteriaBuilder.equal(name, username);
		}
	   };
	   Optional<User> user = userBao.findOne(spec);
	   if(user.isPresent()) {
		   return user.get();
	   }
	   return null;
   }
}
