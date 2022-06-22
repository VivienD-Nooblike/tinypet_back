package com.petitions.restapi.model;

import java.util.Date;
import java.util.HashSet;

import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;

@Data
@Entity(name = "petition")
public class Petition {
	@Id
	private Long id;
	private Long creator;
	private String title;
	private String description;	
	private HashSet<String> tags;
    @Field(name = "signature_number")
	private int signatureNumber;
    @Field(name = "start_date")
    private Date startDate;
    @Field(name = "end_date")
    private Date endDate;
    
    public Petition(Long creator, String title, String description, HashSet<String> tags, int signatureNumber, Date startDate, Date endDate) {
    	this.creator = creator;
    	this.title = title;
    	this.description = description;
    	this.tags = tags;
    	this.signatureNumber = signatureNumber;
    	this.startDate = startDate;
    	this.endDate = endDate;    	
    }
    
    @Override
    public String toString() {
      return "User{" +
          "id=" + this.id +
          ", creator id='" + this.creator + '\'' +
          ", title='" + this.title + '\'' +
          ", description='" + this.description + '\'' +
          ", creation date='" + this.startDate.toString() + '\'' +
          ", ending date='" + this.endDate.toString() + '\'' +
          ", tags='" + this.tags.toString() + '\'' +
          ", number of signatures=" + this.signatureNumber +
          '}';
    }
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    };

    public Long getCreator() {
    	return this.creator;
    };
    
    public void setCreator(Long creator) {
    	this.creator = creator;
    };
    
    public String getTitle() {
    	return this.title;
    };
    
    public void setTitle(String title) {
    	this.title = title;
    };
    
    public String getDescription() {
    	return this.description;
    };	
    
    public void setDescription(String description) {
    	this.description = description;
    };
    
    public HashSet<String> getTags() {
    	return this.tags;
    };
    
    public void setTags(HashSet<String> tags) {
    	this.tags = tags;
    };
    
    public int getSignatureNumber() {
    	return this.signatureNumber;
    };
    
    public void setSignatureNumber(int signatureNumber) {
    	this.signatureNumber = signatureNumber;
    };
    
    public Date getStartDate() {
    	return this.startDate;
    };
    
    public void setStartDate(Date startDate) {
    	this.startDate = startDate;
    };
    
    public Date getEndDate() {
    	return this.endDate;
    };
    
    public void setEndDate(Date endDate) {
    	this.endDate = endDate;
    };
}
