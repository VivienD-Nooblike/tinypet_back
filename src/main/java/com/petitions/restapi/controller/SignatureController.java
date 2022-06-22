package com.petitions.restapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petitions.restapi.model.Petition;
import com.petitions.restapi.model.Signature;
import com.petitions.restapi.model.User;
import com.petitions.restapi.service.PetitionService;
import com.petitions.restapi.service.SignatureService;
import com.petitions.restapi.service.UserService;

@ShellComponent
@RestController
public class SignatureController {
	@Autowired
	private SignatureService signatureService;
	@Autowired
	private PetitionService petitionService;
	@Autowired
	private UserService userService;

	/**
	 * Create - Add a new signature
	 * @param user An object signature
	 * @return The signature object saved
	 */
	@PostMapping("/signature")
    public Signature saveSignature(@RequestBody Signature signature) {
        return signatureService.saveSignature(signature);
    }
	
	/**
	 * Read - Get all signatures
	 * @return An Iterable object of signature full filled
	 */
	@GetMapping("/signatures")
	public Iterable<Signature> getSignatures(){
		Iterable<Signature> it = signatureService.getSignatures();
		System.out.println(it.toString());
		return it;
	}
	
	/**
	 * Read - Get one signature 
	 * @param id The id of the signature
	 * @return A Petition object full filled
	 */
	@GetMapping("/signature/{id}")
	public Signature getSignature(@PathVariable("id") final Long id) {
		Optional<Signature> signature = signatureService.getSignature(id);
		if(signature.isPresent()) {
			return signature.get();
		} else {
			return null;
		}
    }
	
	/**
	 * Delete - Delete one signature 
	 * @param id The id of the signature
	 */	
	@DeleteMapping("/signature/{id}")
    public void deleteSignature(@PathVariable("id") final Long id) {
		signatureService.deleteSignature(id);
    }
	
	//SHELL METHODS
	
	/**
	 * Delete - Delete all signatures 
	 */	
	@ShellMethod("Removes all signatures")
    public void deleteAllSignatures() {
		signatureService.deleteAllSignatures();
    }
	
	/**
	 * Create - Add a certain number of signatures to datastore
	 * @param nb The number of signatures to create
	 */
	@ShellMethod("Add a give number of random signature to the datastore : populate-signatures <number>")
	public String populateSignatures(int nb) {
		ArrayList<Signature> listSignature = new ArrayList<>();//for visual confirmation			
		
		//initializing list for random petition and random user
		List<User> signatories = new ArrayList<User>();
		userService.getUsers().forEach(signatories::add);
		List<Petition> petitions = new ArrayList<Petition>();
		petitionService.getPetitions().forEach(petitions::add);				
		Date date = new Date(System.currentTimeMillis());
		
		for(int i=0 ; i<nb ; i++) {	
			//Signature creation
			Long signatory = signatories.get(ThreadLocalRandom.current().nextInt(0,signatories.size())).getId();
			Long petition = petitions.get(ThreadLocalRandom.current().nextInt(0,petitions.size())).getId();
		    Signature signature = new Signature(signatory, petition, date);
			
		    //Put Signature into data store
			listSignature.add(signature);
		    signatureService.saveSignature(signature);
		}
		
		//visual confirmation
		return listSignature.toString();
	}
}
