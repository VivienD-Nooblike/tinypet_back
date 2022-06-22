package com.petitions.restapi.repository;

import org.springframework.stereotype.Repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.petitions.restapi.model.Petition;

@Repository
public interface PetitionRepository extends DatastoreRepository<Petition, Long> {

}
