package com.BITe.DogWalker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
	List<Dog> findByName(String name);

}
