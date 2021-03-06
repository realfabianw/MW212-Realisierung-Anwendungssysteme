package de.hwglu.portfoliotracker.ticks.control;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import de.hwglu.portfoliotracker.ticks.entity.Tick;


public interface TickRepository extends MongoRepository<Tick, String> {
    List<Tick> findByStockId(String stockId);
    int countByStockIdAndTimestampGreaterThanEqual(String stockId, LocalDateTime timestamp);
}

