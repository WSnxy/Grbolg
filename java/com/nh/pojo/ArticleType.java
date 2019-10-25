package com.nh.pojo;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article_type_t")
public class ArticleType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typeId")
	private Integer typeId;
	@Column(name = "type")
	private String type;


	@ManyToMany(mappedBy = "articleTypes",fetch = FetchType.EAGER)
	private List<ArticleInfo>  articleInfos;
	public String getType() {
		return type;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public List<ArticleInfo> getArticleInfos() {
		return articleInfos;
	}

	public void setArticleInfos(List<ArticleInfo> articleInfos) {
		this.articleInfos = articleInfos;
	}

	public void setType(String type) {
		this.type = type;
	}

}
