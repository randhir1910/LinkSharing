package com.ttnd.linksharing.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "documentResource")
@PrimaryKeyJoinColumn(name = "id")
public class DocumentResource extends Resource {

	private String filePath;

	public DocumentResource() {
		// TODO Auto-generated constructor stub
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
