package de.hwglu.portfoliotracker.stocks.control;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.hwglu.portfoliotracker.stocks.entity.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
    
}

