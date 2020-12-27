package com.usermanagment.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagment.Entity.cityEntity;

public interface cityRepository extends JpaRepository<cityEntity, Serializable> {
	
	public List<cityEntity> findAllByCountryId(Integer countryId);
	
	public List<cityEntity> findAllByStateId(Integer stateId);
	
}
