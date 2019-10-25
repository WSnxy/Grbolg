package com.nh.pojo;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "article_info_t")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")  //使用uuid作为主键
public class ArticleInfo {
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name="articleId")
	private String  id;  //文章id
	@Column(name = "userId",nullable = true)
	private String userId; //用户id
	@Column(name = "title",nullable = true)
	private String title; //文章标题
	@Column(name = "staus")
	private Boolean  staus; //true 1 原创 false 0转载
	@Column(name = "createTime")
	@Temporal(TemporalType.TIMESTAMP) //指定与数据库日期匹配类型
	private Date createTime; //文章创建时间
	@Column(name = "browseCount")
	private Integer browseCount;//文章浏览总数
	@Column(name = "image")
	private String image; //贴图
	@Column(name = "thumbs")
	private Integer thumbs;//点赞数
	@Column(name = "firstLine")
	private String firstLine;//文章第一行
	
//	与文章类型多对多
//	这里不使用懒加载，将文章分类也一并查出
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ArticleType> articleTypes;
	
	public List<ArticleType> getArticleTypes() {
		return articleTypes;
	}
	public void setArticleTypes(List<ArticleType> articleTypes) {
		this.articleTypes = articleTypes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getStaus() {
		return staus;
	}
	public void setStaus(Boolean staus) {
		this.staus = staus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getThumbs() {
		return thumbs;
	}
	public void setThumbs(Integer thumbs) {
		this.thumbs = thumbs;
	}
	public String getFirstLine() {
		return firstLine;
	}
	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}
}
