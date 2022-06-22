package com.petitions.restapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petitions.restapi.model.Petition;
import com.petitions.restapi.repository.PetitionRepository;

import lombok.Data;

@Data
@Service
public class PetitionService {
	@Autowired
	PetitionRepository petitionRepository;

    public Optional<Petition> getPetition(final Long id) {
        return petitionRepository.findById(id);
    }

    public Iterable<Petition> getPetitions() {
        return petitionRepository.findAll();
    }

    public void deletePetition(final Long id) {
    	petitionRepository.deleteById(id);
    }
    
    public void deleteAllPetitions() {
    	petitionRepository.deleteAll();
    }

    public Petition savePetition(Petition petition) {
    	Petition savedPetition = petitionRepository.save(petition);
        return savedPetition;
    }
}
