package com.luv2code.springboot.cruddemo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

  
@Entity
@Table(name="post")
public class Post {
	
	@Id
	@Column(name="id")
	String id;
	
	
	
	
	@Lob
	@Column(name="photo")
	private byte[]	photo;
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Column(name="caption")
	String	caption; 
	
	@Column(name="create_At")
	LocalDateTime createdAt;
	
	
	


@OneToMany(fetch = FetchType.LAZY,
cascade = {CascadeType.ALL})
@JoinColumn(name="co_ID" ,referencedColumnName = "id")
List<Comment> comments ;

@OneToMany(fetch = FetchType.LAZY,
		cascade = {CascadeType.ALL})
		@JoinColumn(name="like_post_ID" ,referencedColumnName = "id")
		List<Likes> likes ;


@JsonIgnore
	public List<Likes> getLikes() {
	return likes;
}

public void setLikes(List<Likes> likes) {
	this.likes = likes;
}
@JsonIgnore
	public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="post_ID")
	User   userId;

	//@JsonBackReference
	@JsonIgnore
	public User getUserId() {
		return userId;
	}
	//@JsonBackReference
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	

	public Post(String id, byte[] photo, String caption, LocalDateTime createdAt) {
		this.id = id;
		this.photo = photo;
		this.caption = caption;
		this.createdAt = createdAt;
	}

	public Post() {
	
	}
 
	@Override
	public String toString() {
		return "Post [id=" + id + ", photo=" + photo + ", caption=" + caption + ", createdAt=" + createdAt + ", userId="
				+ userId + ", comments=" +   "" + "]";
	}
	
 
public Post(String id,  byte[] photo, String caption, LocalDateTime createdAt, User userId) {
	this.id = id;
	this.photo = photo;
	this.caption = caption;
	this.createdAt = createdAt;
	this.userId = userId;
}
	
	

public void addComment(Comment tempComment) {

if (comments == null) {
	comments = new ArrayList<>();
}
tempComment.setPostId(this);
comments.add(tempComment);

}

public void addLikes(Likes like) {

if (likes == null) {
	likes = new ArrayList<>();
}
like.setPostId(this);
likes.add(like);
 
} 
 

}
