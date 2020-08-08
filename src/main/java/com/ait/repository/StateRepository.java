package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity,Serializable>{

}
