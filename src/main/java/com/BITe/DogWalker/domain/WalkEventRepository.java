package com.BITe.DogWalker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WalkEventRepository extends CrudRepository<WalkEvent, Long> {
	List<WalkEvent> findByWalker(@Param("walker")Walker walker);
	List<WalkEvent> findByDog(@Param("dogname")Dog dog);
	List<WalkEvent> findByDogIn(List<Dog> dogs);

}
