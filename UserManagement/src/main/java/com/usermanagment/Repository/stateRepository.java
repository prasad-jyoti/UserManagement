package com.usermanagment.Repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagment.Entity.stateEntity;

public interface stateRepository  extends JpaRepository<stateEntity, Serializable>{
	
	public List<stateEntity> findAllByCountryId(Integer countryId);

}
