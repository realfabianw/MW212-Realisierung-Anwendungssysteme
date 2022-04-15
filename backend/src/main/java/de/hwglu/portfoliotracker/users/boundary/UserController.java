package de.hwglu.portfoliotracker.users.boundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.users.entity.User;

@RestController
public class UserController {
    
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        list.add(new User("Max", "Mustermann", "max.mustermann@mail.de", "1234"));
        list.add(new User("Melanie", "Musterfrau", "melanie.mustermann@mail.de", "4321"));
        return list;
    }
}
