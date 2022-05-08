package de.hwglu.portfoliotracker.stocks.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stock {
    @Id
    private String id;
    private String symbol;
    private String isin;
    private String wkn;
    private String name;
}
