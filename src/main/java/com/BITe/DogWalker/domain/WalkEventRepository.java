package com.BITe.DogWalker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WalkEventRepository extends CrudRepository<WalkEvent, Long> {
	List<WalkEvent> findByWalker(Walker walker);

}
