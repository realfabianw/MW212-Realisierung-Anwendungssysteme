package de.hwglu.portfoliotracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.hwglu.portfoliotracker.users.control.UserRepository;
import de.hwglu.portfoliotracker.users.entity.User;

@SpringBootApplication
public class PortfoliotrackerApplication {
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		// Sieht aus wie ein gutes Tutorial: https://spring.io/guides/tutorials/rest/
		SpringApplication.run(PortfoliotrackerApplication.class, args);
		
	}
	public void run(String... args) throws Exception {

		repository.deleteAll();
	
		// save a couple of customers
		repository.save(new User("Max", "Mustermann", "max.mustermann@mail.de", "1234"));
		repository.save(new User("Max", "Mustermann", "max.mustermann@mail.de", "1234"));
	
		// fetch all customers
		System.out.println("Customers found with findAll():");
		int id = 1;
		System.out.println("-------------------------------");
		repository.getUser(id);
		System.out.println("Hat geklappt"+  repository.getUser(id));
		  
		
		
	  }
	

}
