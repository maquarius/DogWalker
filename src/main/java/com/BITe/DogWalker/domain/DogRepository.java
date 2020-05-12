package com.BITe.DogWalker.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
	List<Dog> findByName(String name);
	List<Dog> findByOwner(Owner owner);

	//Uses Spring Boots JPQL to pass variables in the SQL syntax
	@Query("SELECT t FROM Dog t WHERE OWNER_ID=t")
	List<Dog> findByOwnerId(Long t);
}
