package com.nh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nh.pojo.ArticleType;

@Repository
public interface ArticleTypeDao  extends JpaRepository<ArticleType,Integer>, JpaSpecificationExecutor<ArticleType>{

}
