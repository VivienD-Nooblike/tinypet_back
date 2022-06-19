package com.petitions.restapi.model;

import java.io.Serializable;
import java.sql.Date;

public class SignatureId implements Serializable{
	private int signatory;
	private String petition;
	private Date date;
	
	public SignatureId(int signatory, String petition,Date date) {
		this.signatory = signatory;
		this.petition = petition;
		this.date = date;
	}
}
