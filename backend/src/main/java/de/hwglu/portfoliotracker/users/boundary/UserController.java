package de.hwglu.portfoliotracker.users.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.users.control.UserRepository;
import de.hwglu.portfoliotracker.users.entity.User;
import de.hwglu.portfoliotracker.users.entity.UserRole;

/**
 * The controller class for the User model.
 */
@RestController
public class UserController implements UserDetailsService{
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
	private UserRepository repository;

    @PostMapping("/register")
    public User create(@RequestBody User user){
        user.password = bCryptPasswordEncoder.encode(user.password);
        return repository.save(user);
    }
    
    /**
     * Returns all users from the database. (CRUD - READ) 
     * @return List
     */
    @GetMapping("/users")
    public List<User> getAll(){
        return repository.findAll();
    }

    /**
     * Returns the user with the given id. (CRUD - READ)
     * @param id the users id
     * @return User
     */
    @GetMapping("/users/{id}")
    public Optional<User> getById(@PathVariable String id){
        return repository.findById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        User databaseUser = getById(id).get();
        user.id = databaseUser.id;
        return repository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("no user found with email: " + email));
    }


}
