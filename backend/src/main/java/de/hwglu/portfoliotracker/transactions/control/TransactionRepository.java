package de.hwglu.portfoliotracker.transactions.control;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import de.hwglu.portfoliotracker.transactions.entity.Transaction;

/**
 * see: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories.query-methods.details
 */
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUserId(String userId);
    Optional<Transaction> findByUserIdAndId(String userId, String id);
}
