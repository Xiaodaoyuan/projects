package com.xiaody.spring_boot_demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table
@Entity
@DynamicInsert
@DynamicUpdate
public class Comment {
	private Integer id;
	private Integer blog_id;
	private String content;
	private Date created_at;
	// private Blog blog;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(Integer blog_id) {
		this.blog_id = blog_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "blog_id")
	// public Blog getBlog() {
	// return blog;
	// }
	//
	// public void setBlog(Blog blog) {
	// this.blog = blog;
	// }
}
