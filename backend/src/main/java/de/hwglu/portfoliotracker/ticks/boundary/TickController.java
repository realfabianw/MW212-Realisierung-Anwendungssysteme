package de.hwglu.portfoliotracker.ticks.boundary;

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

import de.hwglu.portfoliotracker.ticks.control.TickRepository;
import de.hwglu.portfoliotracker.ticks.entity.Tick;

@RestController
public class TickController {
    
    @Autowired
    private TickRepository repository;

    /**
     * Creates a new Tick instance and persists it in the database. (CRUD - POST)
     * @param tick
     * @return Tick
     */
    @PostMapping("/ticks")
    public Tick create(@RequestBody Tick tick){
        return repository.save(tick);
    }

    /**
     * Returns all ticks from the database. (CRUD - READ) 
     * @return List
     */
    @GetMapping("/ticks")
    public List<Tick> getTicks(){
        return repository.findAll();
    }

    /**
     * Returns the tick with the given id. (CRUD - READ)
     * @param tickId the ticks id
     * @return Tick
     */
    @GetMapping("/ticks/{tickId}")
    public Optional<Tick> getTicks(@PathVariable String tickId){
        return repository.findById(tickId);
    }

    /**
     * Update the tick with the given id. (CRUD - READ)
     * @param tickId the ticks id
     * @return Tick
     */
    @PutMapping("/ticks/{tickId}")
    public Tick updateStock(@PathVariable String tickId, @RequestBody Tick tick){
        Tick databaseTick = getTicks(tickId).get();
        tick.id = databaseTick.id;
        return repository.save(tick);
    }

    /**
     * Delete the tick with the given id. (CRUD - READ)
     * @param tickId the ticks id
     * @return Tick
     */
    @DeleteMapping("/ticks/{tickId}")
    public void deleteTick(@PathVariable String tickId){
        repository.deleteById(tickId);
    }
}
