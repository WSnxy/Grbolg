package com.nh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nh.pojo.ArticleInfo;

@Repository
public interface ArticleInfoDao extends JpaRepository<ArticleInfo,String>, JpaSpecificationExecutor<ArticleInfo>{

}
