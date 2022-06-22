package com.petitions.restapi.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;

@Data
@Entity(name = "signature")
public class Signature {
	@Id
	Long id;
    @Field(name = "signatory_id")
	private Long signatory;
    @Field(name = "petition_id")
	private Long petition;
	private Date date;
	
	public Signature(Long signatory, Long petition, Date date) {
		this.signatory = signatory;
		this.petition = petition;
		this.date = date;
	}
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getSignatory() {
    	return this.signatory;
    }
    
    public void setSignatory(Long signatory) {
    	this.signatory = signatory;
    }
    
    public Long getPetition() {
    	return this.petition;
    }
    
    public void setPetition(Long petition) {
    	this.petition = petition;
    }
    
    public Date getDate() {
    	return this.date;
    };
    
    public void setDate(Date date) {
    	this.date = date;
    };
}
