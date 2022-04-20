package de.hwglu.portfoliotracker.users.boundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.users.entity.User;

@RestController
public class UserController {

    @PostMapping("/users")
    public boolean createUser(User user){
        // CURD CREATE (instance)
        // Nehme die Instanz die übergeben wurde und füge sie in der Datenbank ein
        return true;
    }
    
    @GetMapping("/users")
    public List<User> getUsers(){

        // CRUD GET (ALL)
        // Geh in die Datenbank und gebe mir alle Nutzer zurück
        // bspw. return userRepository.getAllUsers();

        List<User> list = new ArrayList<>();
        list.add(new User("Max", "Mustermann", "max.mustermann@mail.de", "1234"));
        list.add(new User("Melanie", "Musterfrau", "melanie.mustermann@mail.de", "4321"));
        return list;
    }

    @GetMapping("/users/{id}")
    public User getUser(String id){

        // CRUD GET (BY ID)
        // Geh in die Datenbank und gebe mit den Nutzer mit der übergeben Id zurück
        return new User("Max", "Mustermann", "max.mustermann@mail.de", "1234");
    }

    @PutMapping("/users/{id}")
    public User updateUser(String id, User user){
        // CRUD UPDATE (By ID)
        // Geh in die Datenbank und überschreibe den Nutzer mit der ID mit dem User, der übergeben wurde.
        return null;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(String id){
        // CRUD DELETE (by ID)
        // Geh in die Datenbanken und lösche den User mit der übergebenen ID
        return null;
    }


}
