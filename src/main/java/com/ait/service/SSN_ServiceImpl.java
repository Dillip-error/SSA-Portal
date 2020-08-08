package com.ait.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.bind.SSN_Bind;
import com.ait.customexception.InvalidSocialSecurityNumberException;
import com.ait.entity.SSN_Entity;
import com.ait.entity.StateEntity;
import com.ait.repository.SSN_Repository;
import com.ait.repository.StateRepository;

@Service
public class SSN_ServiceImpl implements ISSN_Service{

	@Autowired
	private SSN_Repository repo;
	@Autowired
	private StateRepository stateRepo;
	
	@Override
	public boolean saveSSNdata(SSN_Bind ssn) {
		SSN_Entity entity = new SSN_Entity();
		BeanUtils.copyProperties(ssn,entity);
		SSN_Entity save = repo.save(entity);
		if(save != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<StateEntity> getAllState() {
		List<StateEntity> findAll = stateRepo.findAll();
		return  findAll;
	}

	@Override
	public Long validateSSN(Integer ssn) {
		Long countSSNNo = null;
	    countSSNNo = repo.countSSNNo(ssn);
	    if(countSSNNo != 0) {
	    	return countSSNNo;
	    }
		else {
			throw new InvalidSocialSecurityNumberException("INVALID SSN ");
		}
	}

}
