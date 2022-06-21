package com.petitions.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petitions.restapi.model.User;
import com.petitions.restapi.service.UserService;

@ShellComponent
@RestController
public class UserController {	
	@Autowired
	private UserService userService;

	/**
	 * Create - Add a new user
	 * @param user An object user
	 * @return The user object saved
	 */
	@PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
	
	/**
	 * Read - Get all users
	 * @return An Iterable object of User full filled
	 */
	@GetMapping("/users")
	public Iterable<User> getUsers(){
		return userService.getUsers();
	}
	
	/**
	 * Read - Get one user 
	 * @param id The id of the user
	 * @return A User object full filled
	 */
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") final String id) {
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
    }
    
	/**
	 * Read - Get all users with this first name and this last name
	 * @param firstName The first name of the user
	 * @param lastName The last name of the user
	 * @return An Employee object full filled
	 */
	@GetMapping("/users/searchName/{firstName}/{lastName}")
	List<User> getUsersByLastNameAndFirstName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
		return userService.getUsersByLastNameAndFirstName(firstName, lastName);
	};
	
	/**
	 * Read - Get one employee
	 * @param id The id of the employee
	 * @return An Employee object full filled
	 */
	@GetMapping("/user/searchMail/{mail}")
	List<User> getUsersByMail(@PathVariable("mail") String mail){
		return userService.getUsersByMail(mail);
	};
	
	/**
	 * Delete - Delete one employee 
	 * @param id The id of the employee
	 */	
	@DeleteMapping("/user/searchId/{id}")
    public void deleteUser(@PathVariable("id") final String id) {
    	userService.deleteUser(id);
    }
	
	//SHELL METHODS
	
	/**
	 * Delete - Delete all users 
	 * @param id The id of the employee
	 */	
	@ShellMethod("Removes all users")
    public void deleteAllUsers() {
    	userService.deleteAllUsers();
    }
	
	/**
	 * Create - Add a certain number of new users
	 * @param nb number of users to be added
	 */
	@ShellMethod("Add a give number of users to the datastore : populate-users <number>")
	public String populateUsers(int nb) {
		ArrayList<User> listUsers = new ArrayList<>();//for visual confirmation
		for (int i=0 ; i<nb ; i++) {			
			//User creation
			String firstName = "first"+i;
			String lastName = "last"+i;
			String mail = firstName+lastName+"@test.fr";
			String password = "test"+i;
			User user = new User(firstName, lastName, mail, password);
					
			//Put user into data store
			listUsers.add(user);
			userService.saveUser(user);
		}
		//visual confirmation
		return listUsers.toString();
	}
}
