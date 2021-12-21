package com.amdocs.bankapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.bankapplication.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Integer> {

	
}
