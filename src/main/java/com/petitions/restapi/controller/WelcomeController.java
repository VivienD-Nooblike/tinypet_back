package com.petitions.restapi.controller;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String greet() {
            return "Hello!";
    }	
	
/**
* Return a random date between startDate and endDate 
*
* @param  startDate	minimum date 
* @param  endDate	maximum date
* @return a LocalDate object between startDate and endDate
*/
public LocalDate randomDateBetween(LocalDate startDate, LocalDate endDate){
	long start = startDate.toEpochDay();
	long end = endDate.toEpochDay();
	long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
	return LocalDate.ofEpochDay(randomEpochDay);
}

}
