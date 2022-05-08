package de.hwglu.portfoliotracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import de.hwglu.portfoliotracker.security.control.JwtTokenProvider;
import de.hwglu.portfoliotracker.users.control.UserRepository;
import de.hwglu.portfoliotracker.users.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class PortfoliotrackerApplication{

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	// @Autowired
	// private UserRepository userRepository;

	// @Autowired
	// private JwtTokenProvider jwtTokenProvider;


	public static void main(String[] args) {
		SpringApplication.run(PortfoliotrackerApplication.class, args);		
	}


	// @Override
	// public void run(String... args) throws Exception {
	// 	try {
	// 		User user = new User();
	// 		user.setEmail("test@test.de");
	// 		user.setPassword(passwordEncoder.encode("1234"));

	// 		User saved = userRepository.save(user);

	// 		System.out.println(jwtTokenProvider.generateToken(saved.getEmail()));
	// 	} catch (Exception e) {
	// 		log.error("Error: ", e);
	// 	}
	// }

}
