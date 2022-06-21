package com.petitions.restapi.model;

import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(name = "user")
public class User {
    @Id
    private String id;
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
}