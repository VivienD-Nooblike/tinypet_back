package com.petitions.restapi.model;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "petition")
public class Petition {
	@Id
	private String id;		
	@Column(name="creator_id")
	private String creator;
	@Column
	private String title;	
	@Column
	private String description;	
	@Column
	private HashSet<String> tags;	
	@Column(name="signature_nb")
	private int signatureNumber;
}
