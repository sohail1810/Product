package com.sathya.springMVC2.EmpRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springMVC2.EmpEntity.EmpEntity;

@Repository
public interface EmpRepository  extends JpaRepository<EmpEntity, Long>
{
	
	
	
}
