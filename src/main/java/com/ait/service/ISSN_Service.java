package com.ait.service;

import java.util.List;

import com.ait.bind.SSN_Bind;
import com.ait.entity.StateEntity;

public interface ISSN_Service {
	
	public boolean saveSSNdata(SSN_Bind ssn);
	public List<StateEntity> getAllState();
	public Long validateSSN(Integer ssn);

}
