package com.petitions.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petitions.restapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
