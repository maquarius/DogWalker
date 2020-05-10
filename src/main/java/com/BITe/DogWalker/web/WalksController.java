package com.BITe.DogWalker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.BITe.DogWalker.domain.Dog;
import com.BITe.DogWalker.domain.DogRepository;
import com.BITe.DogWalker.domain.OwnerRepository;
import com.BITe.DogWalker.domain.WalkerRepository;

@Controller
public class WalksController {
	@Autowired
	private DogRepository dogrepository;

	@Autowired
	private WalkerRepository wrepository;

	@Autowired
	private OwnerRepository orepository;

//ADMIN views
	// Shows the homepage
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}

	// Shows all dogs
	@RequestMapping(value = "/doglist")
	public String doglist(Model model) {
		model.addAttribute("dogs", dogrepository.findAll());
		return "dogs";
	}

	// Shows all owners
	@RequestMapping(value = "/ownerlist")
	public String ownerlist(Model model) {
		model.addAttribute("owners", orepository.findAll());
		return "owners";
	}

	// Shows all walkers
	@RequestMapping(value = "/walkerlist")
	public String walkerlist(Model model) {
		model.addAttribute("walkers", wrepository.findAll());
		return "walkers";
	}
	
	//Method to save a dog to the dog list
	@RequestMapping(value="/saveDog", method = RequestMethod.POST)
	public String saveDog(Dog dog) {
		dogrepository.save(dog);
		return "redirect:doglist";
	}
	
	//Shows form that adds dog to dog list
	@RequestMapping(value="/addDog")
	public String addDog(Model model) {
		model.addAttribute("dog", new Dog());
		return "adddog";
	}
//OWNER views	
	//OWNER HOME
	
	//Shows form that adds dog to dog list but only owner can add own dog
	//NEEEDS DETAILS ABOUT SPECIFC DOG TO OWNER
		@RequestMapping(value="/addDog/{id}")
		public String addDogFromOwner(@PathVariable("id")Long ownerId, Model model) {
			model.addAttribute("dog", new Dog());
			model.addAttribute("owner", orepository.findById(ownerId));
			return "adddog";
		}
	
	//OWNER create walk
		
	//OWNER view walk + edit feedback?
		
		
//WALKER views		
	//WALKER home
		
	//WALKER accept walk
		
	//WALKER finish walk
}
