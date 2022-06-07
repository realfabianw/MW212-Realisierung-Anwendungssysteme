package de.hwglu.portfoliotracker.stocks.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
@CompoundIndex(name = "unique_stock_index", def = "{'symbol':1, 'isin':1, 'wkn':1}", unique = true)
public class Stock {
    @Id
    private String id;
    private String symbol;
    private String isin;
    private String wkn;
    private String name;
}
