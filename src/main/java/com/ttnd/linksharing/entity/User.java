package com.ttnd.linksharing.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private byte[] photo;
	private boolean active = true;
	private boolean admin = false;
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	@Temporal(TemporalType.DATE)
	private Date lastUpdated;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "createdBy")
	Set<Topic> topics;

	public Set<Topic> getTopics() {
		return topics;
	}

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "user")
	List<Subscription> subscription;

	public User(int id, String email, String username, String password, String firstName, String lastName, byte[] photo,
			boolean active, boolean admin, Date dateCreated, Date lastUpdated, Set<Topic> topics,
			List<Subscription> subscription, List<Resource> resourceList) {
		super();
		Id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
		this.active = active;
		this.admin = admin;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.topics = topics;
		this.subscription = subscription;
		this.resourceList = resourceList;
	}

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "createdBy")
	List<Resource> resourceList;

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active + ", admin=" + admin
				+ ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + "]";
	}

}
