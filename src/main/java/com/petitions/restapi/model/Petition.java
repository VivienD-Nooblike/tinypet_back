package com.petitions.restapi.model;

import java.util.Date;
import java.util.HashSet;

import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
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
          ", tags='" + this.tags.toString() + '\'' +
          ", creation date='" + this.startDate.toString() + '\'' +
          ", ending date='" + this.endDate.toString() + '\'' +
          ", tags='" + this.tags.toString() + '\'' +
          ", number of signatures=" + this.signatureNumber +
          '}';
    }
    
    public Long getId() {
    	return this.id;
    }
}
