package com.amdocs.bankapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.bankapplication.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {


}
