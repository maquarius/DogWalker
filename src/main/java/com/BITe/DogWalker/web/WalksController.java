package com.BITe.DogWalker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BITe.DogWalker.domain.Dog;
import com.BITe.DogWalker.domain.DogRepository;
import com.BITe.DogWalker.domain.OwnerRepository;
import com.BITe.DogWalker.domain.WalkEvent;
import com.BITe.DogWalker.domain.WalkEventRepository;
import com.BITe.DogWalker.domain.WalkerRepository;

@Controller
public class WalksController {
	@Autowired
	private DogRepository dogrepository;

	@Autowired
	private WalkerRepository wrepository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private WalkEventRepository eventrepository;

//Logging authorized users in
	@RequestMapping(value = "/login")
	public String login() {
		return "login";

	}

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

	// Shows all walk events
	@RequestMapping(value = "/walkeventlist")
	public String walkeventlist(Model model) {
		model.addAttribute("walkevents", eventrepository.findAll());
		return "walkeventlist";
	}
	
	//RESTful service to get all walk events
	@RequestMapping(value = "/api/walkevents", method = RequestMethod.GET)
	public @ResponseBody List<WalkEvent>walkEventListRest(){
		return (List<WalkEvent>) eventrepository.findAll();
	}
	

	// Shows all walkers
	@RequestMapping(value = "/walkerlist")
	public String walkerlist(Model model) {
		model.addAttribute("walkers", wrepository.findAll());
		return "walkers";
	}

	// Method to save a dog to the dog list
	@RequestMapping(value = "/saveDog", method = RequestMethod.POST)
	public String saveDog(Dog dog) {
		dogrepository.save(dog);
		return "redirect:doglist";
	}

	// Method to save a walk event to the dog list
	@RequestMapping(value = "/saveWalkEvent", method = RequestMethod.POST)
	public String saveWalkEvent(WalkEvent walkEvent) {
		eventrepository.save(walkEvent);
		return "redirect:home";
	}

	// Shows form that adds dog to dog list
	@RequestMapping(value = "/addDog")
	public String addDog(Model model) {
		model.addAttribute("dog", new Dog());
		return "adddog";
	}

//OWNER views	
	// OWNER HOME
	@RequestMapping(value = "/owner/home/{id}")
	public String ownerHome(@PathVariable("id") Long ownerId, Model model) {
		model.addAttribute("dogs", dogrepository.findByOwner(orepository.findById(ownerId).get()));
		// adding.get() actually gets the object
		model.addAttribute("owner", orepository.findById(ownerId).get());
		// by adding "in" in the end it allows to use a whole list to search
		model.addAttribute("walks",
				eventrepository.findByDogIn(dogrepository.findByOwner(orepository.findById(ownerId).get())));
		return "ownerPage";
	}

	// Shows form that adds dog to dog list but only owner can add own dog
	@RequestMapping(value = "/addDog/{id}")
	public String addDogFromOwner(@PathVariable("id") Long ownerId, Model model) {
		model.addAttribute("dog", new Dog());
		model.addAttribute("owner", ownerId);
		return "adddog";
	}

	// OWNER create walk
	@RequestMapping(value = "/addWalkEvent/{id}")
	public String addWalkFromOwner(@PathVariable("id") Long ownerId, Model model) {
		model.addAttribute("event", new WalkEvent());
		model.addAttribute("owner", ownerId);
		model.addAttribute("dogs", dogrepository.findByOwner(orepository.findById(ownerId).get()));
		return "addwalkevent";
	}

	// OWNER view walk + edit feedback?

//WALKER views		
	// WALKER home
	@RequestMapping(value = "/walker/home/{id}")
	public String walkerHome(@PathVariable("id") Long walkerId, Model model) {
		model.addAttribute("walker", wrepository.findById(walkerId).get());
		model.addAttribute("walks", eventrepository.findAll());
		return "walkerPage";
	}

	// WALKER accept walk
	@RequestMapping(value = "/takeWalk/{walkId}/{walkerId}")
	public String acceptWalk(@PathVariable("walkId") Long walkId, @PathVariable("walkerId") Long walkerId,
			Model model) {
		;
		model.addAttribute("walk", eventrepository.findById(walkId).get());
		model.addAttribute("walker", wrepository.findById(walkerId).get());
		return "acceptWalk";
	}

	// WALKER finish walk
}
