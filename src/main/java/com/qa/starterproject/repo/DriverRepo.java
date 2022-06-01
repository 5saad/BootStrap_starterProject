package com.qa.starterproject.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.qa.starterproject.domain.Driver;


@Repository
public interface DriverRepo extends JpaRepository<Driver, Long> {
	
}


