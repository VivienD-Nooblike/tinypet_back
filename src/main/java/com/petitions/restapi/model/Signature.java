package com.petitions.restapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "signature")
public class Signature {
	@Column(name="user_id")
	private int signatory;
	@Column(name="petition_id")
	private String petition;
	@Column(name="signature_date")
	private Date date;
}
