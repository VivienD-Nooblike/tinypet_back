package com.petitions.restapi.model;

import java.util.HashSet;

import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;

@Data
@Entity(name = "petition")
public class Petition {
	@Id
	private String id;
	private String creator;
	private String title;
	private String description;	
	private HashSet<String> tags;
    @Field(name = "signature_number")
	private int signatureNumber;
}
