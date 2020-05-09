package com.BITe.DogWalker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
