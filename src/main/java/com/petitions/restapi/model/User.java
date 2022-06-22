package com.petitions.restapi.model;


import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;

@Data
@Entity(name = "user")
public class User {
	@Id
    private Long id;
    @Field(name = "first_name")
    private String firstName;
    @Field(name = "last_name")
    private String lastName;
    private String mail;
    private String password;
    
    public User(String firstName, String lastName, String mail, String password) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.mail = mail;
    	this.password = password;
    }
    
    @Override
    public String toString() {
      return "User{" +
          "id=" + this.id +
          ", first name='" + this.firstName + '\'' +
          ", last name='" + this.lastName + '\'' +
          ", mail='" + this.mail + '\'' +
          ", password=" + this.password +
          '}';
    }
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public String getMail() {
    	return this.mail;
    }
    
    public void setMail(String mail) {
    	this.mail = mail;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}