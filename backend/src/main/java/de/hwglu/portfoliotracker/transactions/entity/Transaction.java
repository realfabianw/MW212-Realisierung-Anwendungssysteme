package de.hwglu.portfoliotracker.transactions.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Transaction {
    @Id
    private String id;
    private String stockId;
    private String userId;
    private LocalDateTime timestamp;
    private TransactionType transactionType;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal quantity;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal amount;
    private String currency;
}
