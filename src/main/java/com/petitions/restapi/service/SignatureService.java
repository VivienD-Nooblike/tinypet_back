package com.petitions.restapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.petitions.restapi.model.Signature;
import com.petitions.restapi.repository.SignatureRepository;

public class SignatureService {
	@Autowired
	SignatureRepository signatureRepository;

    public Optional<Signature> getSignature(final Long id) {
        return signatureRepository.findById(id);
    }

    public Iterable<Signature> getSignatures() {
        return signatureRepository.findAll();
    }

    public void deleteSignature(final Long id) {
    	signatureRepository.deleteById(id);
    }
    
    public void deleteAllSignatures() {
    	signatureRepository.deleteAll();
    }

    public Signature saveSignature(Signature signature) {
    	Signature savedSignature = signatureRepository.save(signature);
        return savedSignature;
    }

}
