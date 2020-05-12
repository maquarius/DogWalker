package com.BITe.DogWalker.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserPersonRepository extends CrudRepository<UserPerson, Long> {
	UserPerson findByUsername(String username);
}
