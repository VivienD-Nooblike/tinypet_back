package com.petitions.restapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@IdClass(SignatureId.class)
@Table(name = "signature")
public class Signature {
	@Id
	@Column(name="user_id")
	private int signatory;
	@Id
	@Column(name="petition_id")
	private String petition;
	@Id
	@Column(name="signature_date")
	private Date date;
}
