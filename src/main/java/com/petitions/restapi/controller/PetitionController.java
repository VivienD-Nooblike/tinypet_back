package com.petitions.restapi.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
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
import com.petitions.restapi.service.PetitionService;
import com.petitions.restapi.service.UserService;

@ShellComponent
@RestController
public class PetitionController {
	@Autowired
	private PetitionService petitionService;
	@Autowired
	private UserService userService;

	/**
	 * Create - Add a new petition
	 * @param user An object petition
	 * @return The petition object saved
	 */
	@PostMapping("/petition")
    public Petition savePetition(@RequestBody Petition petition) {
        return petitionService.savePetition(petition);
    }
	
	/**
	 * Read - Get all petitions
	 * @return An Iterable object of Petition full filled
	 */
	@GetMapping("/petitions")
	public Iterable<Petition> getPetitions(){
		Iterable<Petition> it = petitionService.getPetitions();
		System.out.println(it.toString());
		return it;
	}
	
	/**
	 * Read - Get one petition 
	 * @param id The id of the petition
	 * @return A Petition object full filled
	 */
	@GetMapping("/petition/{id}")
	public Petition getPetition(@PathVariable("id") final Long id) {
		Optional<Petition> petition = petitionService.getPetition(id);
		if(petition.isPresent()) {
			return petition.get();
		} else {
			return null;
		}
    }
	
	/**
	 * Delete - Delete one petition 
	 * @param id The id of the petition
	 */	
	@DeleteMapping("/petition/{id}")
    public void deletePetition(@PathVariable("id") final Long id) {
		petitionService.deletePetition(id);
    }
	
	//SHELL METHODS
	
	/**
	 * Delete - Delete all petitions 
	 */	
	@ShellMethod("Removes all petitions")
    public void deleteAllPetitions() {
		petitionService.deleteAllPetitions();
    }
	
	/**
	 * Create - Add a certain number of new petitions
	 * @param nb number of petitions to be added
	 */
	@ShellMethod("Add a give number of random petition to the datastore : populate-petitions <number>")
	public String populatePetitions(int nb) {
		ArrayList<Petition> listPetition = new ArrayList<>();//for visual confirmation
		for (int i=0 ; i<nb ; i++) {			
			//Petition creationthis.creator = creator;
			Long userId = userService.getUsers().iterator().next().getId();
	    	String title = "Petition Title - "+i;
	    	String description = "The description of petition n°"+i;
	    	HashSet<String> tags = randomTags(Math.floorMod(i, 5)+1);
	    	int signatureNumber = ThreadLocalRandom.current().nextInt(0,500);
	    	Date startDate = randomDate();
	    	Date endDate = null;  
			Petition petition = new Petition(userId, title, description, tags, signatureNumber, startDate, endDate);
					
			//Put Petition into data store
			listPetition.add(petition);
			petitionService.savePetition(null);
		}
		//visual confirmation
		return listPetition.toString();
	}
	
	/**
	* Return a random date between January 01, 2022 and today 
	* 
	* @return a Date object
	*/
	public Date randomDate(){
		Long start = new GregorianCalendar(2022, Calendar.JANUARY, 01).getTimeInMillis();
		Long end = System.currentTimeMillis();
		Long random = ThreadLocalRandom.current().nextLong(start,end);
		return new Date(random);
	}
	
	/**
	* Return a random HashSet<String> containing the number of tags given as a parameter
	* 
	* @param nb number of tags wanted
	* @return a HashSet<String> object containing a list of random tags
	*/
	public HashSet<String> randomTags(int nb){
		String tags[] = {"#DroitDeLHomme","#Animaux","#Politique","#France","#Europe","#Internationnal", 
				"#Environnement", "#JusticeEconomique", "#Sante", "#DroitsDesFemmes","#DroitsDesMigrants",
				"#JusticePenale", "#Education", "#Handicap", "#Famille", "#Patrimoine", "#Autre"};
		HashSet<String> result = new HashSet<String>();
		for(int i=0 ; i<nb ; i++) {
			result.add(tags[ThreadLocalRandom.current().nextInt(0,18)]);
		}
		return result;
	}
}
