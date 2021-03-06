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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.alphavantage.control.AlphaVantageService;
import de.hwglu.portfoliotracker.ticks.control.TickRepository;
import de.hwglu.portfoliotracker.ticks.entity.Tick;

@RestController
public class TickController {

    @Autowired
    private TickRepository repository;

    @Autowired
    private AlphaVantageService alphaVantageService;

    /**
     * Creates a new Tick instance and persists it in the database. (CRUD - POST)
     * 
     * @param tick
     * @return Tick
     */
    @PostMapping("/ticks")
    public Tick create(@RequestBody Tick tick) {
        return repository.save(tick);
    }

    /**
     * Returns all ticks from the database. (CRUD - READ)
     * 
     * @return List
     */
    @GetMapping("/ticks")
    public List<Tick> getAll(@RequestParam(required = false) String stockId) {
        if (stockId != null) {
            alphaVantageService.fetchDailyTicksIfNotExists(stockId);
            return repository.findByStockId(stockId);
        } else {
            return repository.findAll();
        }
    }

    /**
     * Returns the tick with the given id. (CRUD - READ)
     * 
     * @param tickId the ticks id
     * @return Tick
     */
    @GetMapping("/ticks/{tickId}")
    public Optional<Tick> get(@PathVariable String tickId) {
        return repository.findById(tickId);
    }

    /**
     * Update the tick with the given id. (CRUD - READ)
     * 
     * @param tickId the ticks id
     * @return Tick
     */
    @PutMapping("/ticks/{tickId}")
    public Tick update(@PathVariable String tickId, @RequestBody Tick tick) {
        Tick databaseTick = get(tickId).get();
        tick.setId(databaseTick.getId());
        return repository.save(tick);
    }

    /**
     * Delete the tick with the given id. (CRUD - READ)
     * 
     * @param tickId the ticks id
     * @return Tick
     */
    @DeleteMapping("/ticks/{tickId}")
    public void delete(@PathVariable String tickId) {
        repository.deleteById(tickId);
    }
}
