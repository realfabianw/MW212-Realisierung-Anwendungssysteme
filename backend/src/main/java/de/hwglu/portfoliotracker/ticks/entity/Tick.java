package de.hwglu.portfoliotracker.ticks.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
@CompoundIndex(name = "unique_tick_index", def = "{'stockId':1, 'interval':1, 'timestamp':1, 'exchange':1}", unique = true)
public class Tick {
    @Id
    private String id;
    private String stockId;
    private Interval interval;
    private LocalDateTime timestamp;
    private String exchange;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private String currency;

    public Tick(String stockId, Interval interval, LocalDateTime timestamp, String exchange, BigDecimal open,
            BigDecimal high, BigDecimal low, BigDecimal close, String currency) {
        this.stockId = stockId;
        this.interval = interval;
        this.timestamp = timestamp;
        this.exchange = exchange;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.currency = currency;
    }
}
