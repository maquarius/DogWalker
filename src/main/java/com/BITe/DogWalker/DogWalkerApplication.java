package com.BITe.DogWalker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BITe.DogWalker.domain.Dog;
import com.BITe.DogWalker.domain.DogRepository;
import com.BITe.DogWalker.domain.Owner;
import com.BITe.DogWalker.domain.OwnerRepository;
import com.BITe.DogWalker.domain.Walker;
import com.BITe.DogWalker.domain.WalkerRepository;

@SpringBootApplication
public class DogWalkerApplication {
	private static final Logger Log = LoggerFactory.getLogger(DogWalkerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogWalkerApplication.class, args);
	}

	@Bean 
	public CommandLineRunner dogWalksDemo (DogRepository drepository, OwnerRepository orepository, WalkerRepository wrepository) {
		return (args)->{
			Log.info("Log some Owners");
			orepository.save(new Owner("Määtie 6b", "helly@hansen.fi", "Helly", "Hansen", 35844746));
			orepository.save(new Owner("Plattestraat 3", "willemBoer@hatmail.nl", "willem", "Boer", 061634));
			orepository.save(new Owner("Treestreet 5", "robin@hood.gb", "Robin", "Hood", 050456));
			
			Log.info("Log some Walkers");
			wrepository.save(new Walker("Johhny","Walker", "johnnyWalker@talkie.gb", "Irishstreet 49", 83848, 50));
			wrepository.save(new Walker("Appi","Heijn", "AppiHeijn@ah.nl", "Zaansestraat 4", 528673, 40));
			
			Log.info("Log some Dogs");
			drepository.save(new Dog(orepository.findByFirstName("Helly").get(0),"Haiku","Needs many bones", 20));
			drepository.save(new Dog(orepository.findByFirstName("willem").get(0),"Bopsie","On a diet", 60));
			drepository.save(new Dog(orepository.findByFirstName("Robin").get(0),"waffle","agressive towards puppies", 30));
			
		};
	}

}
