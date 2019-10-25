package com.nh.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "article_content_t")
public class ArticleContent {

	@Id
	@Column(name = "articleId")
	private String articleId;    //使用
	
	@Lob
	@Column(name="comment")
	private String comment;
	
	@Lob
	@Column(name = "content")
	private String content;


	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
