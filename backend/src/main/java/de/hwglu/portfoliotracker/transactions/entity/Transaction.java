package de.hwglu.portfoliotracker.transactions.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    public String id;
    public String stockId;
    public String userId;
    public LocalDateTime timestamp;
    public TransactionType transactionType;
    public BigDecimal quantity;
    public Price price;
}
