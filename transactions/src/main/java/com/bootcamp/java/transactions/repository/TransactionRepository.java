package com.bootcamp.java.transactions.repository;

import com.bootcamp.java.transactions.domain.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
    Mono<Transaction> findByIdentityNumber(String identityNumber);
}
