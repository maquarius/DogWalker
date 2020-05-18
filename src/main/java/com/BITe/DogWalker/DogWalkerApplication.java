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
import com.BITe.DogWalker.domain.UserPerson;
import com.BITe.DogWalker.domain.UserPersonRepository;
import com.BITe.DogWalker.domain.WalkEvent;
import com.BITe.DogWalker.domain.WalkEventRepository;
import com.BITe.DogWalker.domain.Walker;
import com.BITe.DogWalker.domain.WalkerRepository;

@SpringBootApplication
public class DogWalkerApplication {
	private static final Logger Log = LoggerFactory.getLogger(DogWalkerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogWalkerApplication.class, args);
	}

	@Bean
	public CommandLineRunner dogWalksDemo(UserPersonRepository urepository, WalkEventRepository walkeventrepository,
			DogRepository drepository, OwnerRepository orepository, WalkerRepository wrepository) {
		return (args) -> {
			Log.info("Log some Owners");
			orepository.save(new Owner("Määtie 6b", "helly@hansen.fi", "Helly", "Hansen", 35844746));
			orepository.save(new Owner("Plattestraat 3", "willemBoer@hatmail.nl", "willem", "Boer", 061634));
			orepository.save(new Owner("Treestreet 5", "robin@hood.gb", "Robin", "Hood", 050456));

			Log.info("Log some Walkers");
			wrepository.save(new Walker("Johhny", "Walker", "johnnyWalker@talkie.gb", "Irishstreet 49", 83848, 50));
			wrepository.save(new Walker("Appi", "Heijn", "AppiHeijn@ah.nl", "Zaansestraat 4", 528673, 40));

			Log.info("Log some Dogs");
			drepository.save(new Dog(orepository.findByFirstName("Helly").get(0), "Haiku", "Needs many bones", 20));
			drepository.save(new Dog(orepository.findByFirstName("willem").get(0), "Bopsie", "On a diet", 60));
			drepository.save(
					new Dog(orepository.findByFirstName("Robin").get(0), "waffle", "agressive towards puppies", 30));

			Log.info("Logging some walking events");
			walkeventrepository.save(
					new WalkEvent(drepository.findByName("Haiku").get(0), wrepository.findByFirstName("Johhny").get(0),
							"Ratapihantie 13", "Short round today", "17-05-2020", "13:45", "Ratapihantie 14", 100));

			// Password=hello1/2. BCrypt 10 rounds
			UserPerson user1 = new UserPerson("owner", "$2a$10$ZW2G2JhqGKquDMzJWuQn.etWhOExhGz7FEX24AEapmDWKhh1bqjUi",
					"OWNER");
			UserPerson user2 = new UserPerson("walker", "$2a$10$qSz86wu1yUFUnjfDyEu0p.uurYQJDe234uUPEFnUZxvGfvZEE2OUu",
					"WALKER");
			UserPerson user3 = new UserPerson("admin", "$2a$10$q9Mf4TgXObMoE2xdxvsmAuaD63Co4HjDxZXS7Pf41mxhGbANkLkJa",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
		};
	}

}
