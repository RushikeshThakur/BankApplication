package com.amdocs.bankapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue
	@Column(name = "AccountID")
	private int accountid;
	
	@Column(name = "BranchName")
	private String branchname;
	
	@Column(name = "AccountType")
	private String accounttype;
	
	@Column(name = "AccountBalance")
	private int accountbalance;
	
}
