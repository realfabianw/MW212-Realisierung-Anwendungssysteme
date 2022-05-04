package de.hwglu.portfoliotracker.stocks.entity;

import org.springframework.data.annotation.Id;

public class Stock {
    @Id
    public String id;
    public String symbol;
    public String isin;
    public String wkn;
    public String name;
}
