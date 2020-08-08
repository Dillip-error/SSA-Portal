package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ait.entity.SSN_Entity;

public interface SSN_Repository extends JpaRepository<SSN_Entity,Serializable>{

	@Query("SELECT COUNT(ssnNo) FROM SSN_Entity  WHERE ssnNo=:ssnNo")
	public Long countSSNNo(Integer ssnNo);
}
