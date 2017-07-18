package com.ttnd.linksharing.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ttnd.linksharing.constant.Visibility;

@Entity
@Table(name="topic")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	@Temporal(TemporalType.DATE)
	private Date lastUpdated;
	private Visibility visibility;
	
	@ManyToOne
	User createdBy;
	
	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public User getCreatedBy() {
		return createdBy;
	}
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="topic")
	List<Subscription> subscription;
	
	public List<Subscription> getSubscription() {
		return subscription;
	}

	public void setSubscription(List<Subscription> subscription) {
		this.subscription = subscription;
	}

	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="topic")
	List<Resource> resourceList;;

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}
	
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
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

	public Visibility getVisibility() {
		return visibility;
	}
}
