package com.petitions.restapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.petitions.restapi.model.User;

@Repository
public interface UserRepository extends DatastoreRepository<User, Long> {
	List<User> findByFullName(String firstName, String lastName);
	List<User> findByMail(String mail);
}
