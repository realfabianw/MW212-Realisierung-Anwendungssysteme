package de.hwglu.portfoliotracker.transactions.boundary;

import java.nio.channels.NotYetConnectedException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hwglu.portfoliotracker.transactions.control.TransactionRepository;
import de.hwglu.portfoliotracker.transactions.entity.Transaction;

@RestController
public class TransactionController {
    @Autowired
	private TransactionRepository repository;

    /**
     * Creates a new instance and persists it in the database. (CRUD - POST)
     * @param transaction
     * @return Transaction
     */
    @PostMapping("/users/{userId}/transactions")
    public Transaction create(@PathVariable String userId, @RequestBody Transaction transaction){
        transaction.userId = userId;
        return repository.save(transaction);
    }

     /**
     * Returns all transactions from the database. (CRUD - READ) 
     * @return List
     */
    @GetMapping("/users/{userId}/transactions")
    public List<Transaction> getAll(@PathVariable String userId){
        return repository.findByUserId(userId);
    }

    /**
     * Returns the given transaction with the given id. (CRUD - READ)
     * @param id the users id
     * @return User
     */
    @GetMapping("/transactions/{transactionId}")
    public Optional<Transaction> get(@PathVariable String transactionId){
        return repository.findById(transactionId);
    }

    /**
     * Finds a perstisted transaction and replaces it with the new one.
     * @param id
     * @param transaction
     * @return Transaction
     */
    @PutMapping("/transactions/{transactionId}")
    public Transaction updateOne(@PathVariable String transactionId, @RequestBody Transaction transaction){
        Optional<Transaction> databaseTransaction = repository.findById(transactionId);
        transaction.id = databaseTransaction.get().id;
        return repository.save(transaction);
    }

    /**
     * Deletes a persisted transaction.
     * @param userId
     * @param id
     */
    @DeleteMapping("transactions/{transactionId}")
    public void deleteUser(@PathVariable String transactionId){
        repository.deleteById(transactionId);
        throw new NotYetConnectedException();
    }
}
