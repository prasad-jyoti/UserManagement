package com.usermanagment.Repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagment.Entity.countryEntity;

public interface countryRepository extends JpaRepository<countryEntity, Serializable>{

}
