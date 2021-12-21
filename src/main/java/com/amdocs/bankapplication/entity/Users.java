package com.amdocs.bankapplication.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "UserID")
	private int userid;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "EmailID")
	private String emailid;
	
	@Column(name = "MobileNumber")
	private String mobilenumber;
	
	@Column(name = "SecondaryMobile")
	private String secondarymobile;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "Gender")
	private String gender;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="UserIdFK", referencedColumnName="UserID")
	private List<Accounts> accounts;
	
}
