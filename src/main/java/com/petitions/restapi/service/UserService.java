package com.petitions.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petitions.restapi.model.User;
import com.petitions.restapi.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long id) {
    	userRepository.deleteById(id);
    }
    
    public void deleteAllUsers() {
    	userRepository.deleteAll();
    }

    public User saveUser(User user) {
    	User savedUser = userRepository.save(user);
        return savedUser;
    }
    

	public List<User> getUsersByFullName(String firstName, String lastName){
		return userRepository.findByFullName(firstName, lastName);
	};
	
	public List<User> getUsersByMail(String mail){
		return userRepository.findByMail(mail);
	};
	
}
