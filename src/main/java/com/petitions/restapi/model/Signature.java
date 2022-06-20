package com.petitions.restapi.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;

import lombok.Data;

@Data
@Entity(name = "signature")
public class Signature {
	@Id
    @Field(name = "signatory_id")
	private int signatory;
    @Field(name = "petition_id")
	private String petition;
	private Date date;
}
