package com.bootcamp.java.transactions.service;

import com.bootcamp.java.transactions.domain.Transaction;
import com.bootcamp.java.transactions.repository.TransactionRepository;
import com.bootcamp.java.transactions.web.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    //Llama a los méodos que están en el repositoey
    public Flux<Transaction> findAll(){
        log.debug("findAll executed");
        return transactionRepository.findAll();
    }

    public Mono<Transaction> findById(String customerId){
        log.debug("findById executed {}", customerId);
        return transactionRepository.findById(customerId);
    }
    //Se guarda en el repositorio
    public Mono<Transaction> create(Transaction credit){
        log.debug("create executed {}", credit);
        return transactionRepository.save(credit);
    }
    public Mono<Transaction> update(String creditId, Transaction credit){
        log.debug("update executed {}:{}", creditId, credit);
        //Se busca por ID is existe se actualiza
        return transactionRepository.findById(creditId)
                .flatMap(dbCustomer -> {
                    return transactionRepository.save(dbCustomer);
                });
    }

    public Mono<Transaction> delete(String customerId){
        log.debug("delete executed {}", customerId);
        return transactionRepository.findById(customerId)
                .flatMap(existingCustomer -> transactionRepository.delete(existingCustomer)
                        .then(Mono.just(existingCustomer)));
    }
}
