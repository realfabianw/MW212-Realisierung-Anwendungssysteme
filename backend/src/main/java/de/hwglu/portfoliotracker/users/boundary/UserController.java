package de.hwglu.portfoliotracker.users.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.users.control.UserRepository;
import de.hwglu.portfoliotracker.users.entity.User;

/**
 * The controller class for the User model.
 */
@RestController
public class UserController {

    @Autowired
	private UserRepository repository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return repository.save(user);
    }
    
    /**
     * Returns all users from the database. (CRUD - READ) 
     * @return List
     */
    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.findAll();
    }

    /**
     * Returns the user with the given id. (CRUD - READ)
     * @param id the users id
     * @return User
     */
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return repository.findById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        User databaseUser = getUser(id).get();
        user.setId(databaseUser.getId());
        return repository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id){
        repository.deleteById(id);
    }


}
