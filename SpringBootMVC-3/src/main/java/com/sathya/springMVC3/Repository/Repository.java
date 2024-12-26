package com.sathya.springMVC3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Entity;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Entity, Long>
{

}
