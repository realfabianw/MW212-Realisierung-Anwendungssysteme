package de.hwglu.portfoliotracker.transactions.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction {
    @Id
    private String id;
    private String stockId;
    private String userId;
    private LocalDateTime timestamp;
    private TransactionType transactionType;
    private BigDecimal quantity;
    private BigDecimal amount;
    private String currency;
}
