package com.qa.starterproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.starterproject.domain.Car;


@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
	
	@Query(value = "SELECT * FROM CAR where make = ?1", nativeQuery = true)
	public List<Car> findByMake(String str);
	
	@Query("SELECT c from Car c WHERE c.cost < ?1")
	List<Car> lessThan(int num);
	
//	@Query(value = "SELECT * FROM CAR WHERE COST < ?1", nativeQuery = true)
//	public List<Car> lessThan(int num);
}


