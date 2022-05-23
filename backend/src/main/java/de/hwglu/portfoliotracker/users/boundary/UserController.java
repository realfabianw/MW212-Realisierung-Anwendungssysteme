package de.hwglu.portfoliotracker.users.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.security.control.JwtTokenProvider;
import de.hwglu.portfoliotracker.users.control.UserRepository;
import de.hwglu.portfoliotracker.users.entity.User;

/**
 * The controller class for the User model.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public User create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()));

        return jwtTokenProvider.generateToken(authentication);
    }

    /**
     * Returns all users from the database. (CRUD - READ)
     * 
     * @return List
     */
    @GetMapping("/users")
    public List<User> getAll() {
        return repository.findAll();
    }

    /**
     * Returns the user with the given id. (CRUD - READ)
     * 
     * @param id the users id
     * @return User
     */
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return repository.findById(id);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        User databaseUser = getUser(id).get();
        user.setId(databaseUser.getId());
        return repository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
