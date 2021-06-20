package com.luv2code.springboot.cruddemo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class User {

	@Id
	@Column(name = "user_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "user_Name")
	String userName;

	@Column(name = "email")
	String email;

	@Column(name = "title")
	String title;

	@Column(name = "password")
	String password;

	@Column(name = "role")
	int role;

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Column(name = "phone")
	String phone;

	@Column(name = "facebook_Url")
	String facebookUrl;

	@Column(name = "create_At")
	LocalDateTime createdAt;

	@Column(name = "otp")
	int otp;

	@Column(name = "first_time")
	int firstTime;

	@Column(name = "Token")
	String Token;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "post_ID", referencedColumnName = "user_ID")
	List<Post> posts = new ArrayList<Post>();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_ID", referencedColumnName = "user_ID")
	List<Meeting> meetings;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "expert_ID", referencedColumnName = "user_ID")
	List<Artical> articals;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "p_ID", referencedColumnName = "user_ID")
	List<Product> products;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_comment_id", referencedColumnName = "user_ID")
	List<Comment> comments;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "like_user_id", referencedColumnName = "user_ID")
	List<Likes> likes;

	@JsonIgnore
	public List<Likes> getLikes() {
		return likes;
	}

//	@JsonManagedReference
	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	// @JsonManagedReference
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

//	@JsonManagedReference
	@JsonIgnore
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

//	@JsonManagedReference
	@JsonIgnore
	public List<Artical> getArticals() {
		return articals;
	}

	public void setArticals(List<Artical> articals) {
		this.articals = articals;
	}

	@JsonIgnore
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

//	@JsonManagedReference
	@JsonIgnore
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public int getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(int firstTime) {
		this.firstTime = firstTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", title=" + title + ", password="
				+ password + ", role=" + role + ", photo=" + photo + ", phone=" + phone + ", facebookUrl=" + facebookUrl
				+ ", createdAt=" + createdAt + ", otp=" + otp + ", firstTime=" + firstTime + "]";
	}

	public User(int id, String userName, String email, String title, String password, int role, byte[] photo,
			String phone, String facebookUrl, LocalDateTime createdAt, int firstTime) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.title = title;
		this.password = password;
		this.role = role;
		this.photo = photo;
		this.phone = phone;
		this.facebookUrl = facebookUrl;
		this.createdAt = createdAt;
		this.firstTime = firstTime;
	}

	public User() {

	}

	public User(int id, String userName, String email, String title, String password, byte[] photo, String phone,
			String facebookUrl, int firstTime) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.title = title;
		this.password = password;
		this.photo = photo;
		this.phone = phone;
		this.facebookUrl = facebookUrl;
		this.firstTime = firstTime;
	}

	public void addPost(Post post) {

		if (posts == null) {
			posts = new ArrayList<>();
		}

		posts.add(post);
		post.setUserId(this);
	}

	public void addMeeting(Meeting meeting) {

		if (meetings == null) {
			meetings = new ArrayList<>();
		}

		meetings.add(meeting);

	}

	public void addArticals(Artical artical) {

		if (articals == null) {
			articals = new ArrayList<>();
		}

		articals.add(artical);

		artical.setExpertId(this);
	}

	public void addProduct(Product product) {

		if (products == null) {
			products = new ArrayList<>();
		}

		products.add(product);
		product.setProductId(this);

	}

	public void addComment(Comment tempComment) {

		if (comments == null) {
			comments = new ArrayList<>();
		}

		comments.add(tempComment);
		tempComment.setUserId(this);
	}

	public void addLikes(Likes like) {

		if (likes == null) {
			likes = new ArrayList<>();
		}
		like.setUserId(this);
		likes.add(like);

	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "followers", joinColumns = @JoinColumn(name = "user_user_ID"), inverseJoinColumns = @JoinColumn(name = "follow_user_id"))
	protected List<User> friends;

	@JsonIgnore
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	Set<UserPlant> userPlants;

	public void setUserPlants(Set<UserPlant> userPlants) {
		this.userPlants = userPlants;
	}

	@JsonIgnore
	public Set<UserPlant> getUserPlants() {
		return userPlants;
	}

}

//remove all one to many 