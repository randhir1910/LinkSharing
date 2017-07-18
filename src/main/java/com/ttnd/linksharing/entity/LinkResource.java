package com.ttnd.linksharing.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "linkResource")
@PrimaryKeyJoinColumn(name = "id")
public class LinkResource extends Resource {

	private String url;

	public LinkResource() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
