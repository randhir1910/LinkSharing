package com.ttnd.linksharing.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ttnd.linksharing.constant.Seriousness;

@Entity
@Table(name = "subscription")
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	User user;
	Seriousness seriousness;
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	@ManyToOne
	Topic topic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Seriousness getSeriousness() {
		return seriousness;
	}

	public void setSeriousness(Seriousness seriousness) {
		this.seriousness = seriousness;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
