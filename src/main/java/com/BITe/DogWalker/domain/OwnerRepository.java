package com.BITe.DogWalker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	List<Owner> findByAdress(String adress);
	List<Owner> findByFirstName(String firstName);
}






