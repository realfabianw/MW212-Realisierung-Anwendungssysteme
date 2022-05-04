package de.hwglu.portfoliotracker.ticks.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import de.hwglu.portfoliotracker.transactions.entity.Price;

public class Tick {
    @Id
    public String id;
    public String stockId;
    public LocalDateTime timestamp;
    public String exchange;
    public Price price;
}
