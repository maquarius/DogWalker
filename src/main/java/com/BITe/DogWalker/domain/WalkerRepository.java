package com.BITe.DogWalker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WalkerRepository extends CrudRepository<Walker, Long> {
	List<Walker> findByLastName(String lastName);
	List<Walker> findByFirstName(String firstName);
}
