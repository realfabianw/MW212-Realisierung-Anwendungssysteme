package de.hwglu.portfoliotracker.users.control;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.hwglu.portfoliotracker.users.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
