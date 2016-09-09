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
public class Blog {
	private Integer id;
	private Integer user_id;
	private String name;
	private String summary;
	private String content;
	private Date created_at;
	// private User user;
	// private Set<Comment> comments;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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
	// @JoinColumn(name = "user_id")
	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }
	//
	// @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	// public Set<Comment> getComments() {
	// return comments;
	// }
	//
	// public void setComments(Set<Comment> comments) {
	// this.comments = comments;
	// }

}
