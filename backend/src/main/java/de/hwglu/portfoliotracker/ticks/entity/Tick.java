package de.hwglu.portfoliotracker.ticks.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

public class Tick {
    @Id
    public String id;
    public String stockId;
    public LocalDateTime timestamp;
    public String exchange;
    public BigDecimal open;
    public BigDecimal high;
    public BigDecimal low;
    public BigDecimal close;
    public String currency;

    public Tick(String stockId, LocalDateTime timestamp, String exchange, BigDecimal open, BigDecimal high,
            BigDecimal low, BigDecimal close, String currency) {
        this.stockId = stockId;
        this.timestamp = timestamp;
        this.exchange = exchange;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.currency = currency;
    }
}
