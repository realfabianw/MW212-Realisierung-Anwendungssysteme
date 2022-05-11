package de.hwglu.portfoliotracker.stocks.boundary;

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

import de.hwglu.portfoliotracker.stocks.control.StockRepository;
import de.hwglu.portfoliotracker.stocks.entity.Stock;

@RestController
public class StockController {
    @Autowired
    private StockRepository repository;

    /**
     * Creates a new stock instance and persists it in the database. (CRUD - POST)
     * 
     * @param stock
     * @return Stock
     */
    @PostMapping("/stocks")
    public Stock create(@RequestBody Stock stock) {
        return repository.save(stock);
    }

    /**
     * Returns all stocks from the database. (CRUD - READ)
     * 
     * @return List
     */
    @GetMapping("/stocks")
    public List<Stock> getStocks() {
        return repository.findAll();
    }

    /**
     * Returns the stock with the given id. (CRUD - READ)
     * 
     * @param stockId the stocks id
     * @return Stock
     */
    @GetMapping("/stocks/{stockId}")
    public Optional<Stock> getStocks(@PathVariable String stockId) {
        return repository.findById(stockId);
    }

    @PutMapping("/stocks/{stockId}")
    public Stock updateStock(@PathVariable String stockId, @RequestBody Stock stock) {
        Stock databaseStock = getStocks(stockId).get();
        stock.setId(databaseStock.getId());
        return repository.save(stock);
    }

    @DeleteMapping("/stocks/{stockId}")
    public void deleteStock(@PathVariable String stockId) {
        repository.deleteById(stockId);
    }

}
