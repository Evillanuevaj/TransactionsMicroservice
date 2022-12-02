package com.bootcamp.java.transactions.web;

import com.bootcamp.java.transactions.domain.Transaction;
import com.bootcamp.java.transactions.service.TransactionService;
import com.bootcamp.java.transactions.web.mapper.TransactionMapper;
import com.bootcamp.java.transactions.web.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {
    @Value("${spring.application.name}")
    String name;
    @Value("${server.port}")
    String port;

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionMapper transactionMapper;
    @GetMapping
    public Mono<ResponseEntity<Flux<TransactionModel>>> getAll(){
        log.info("getAll executed");
        return Mono.just(ResponseEntity.ok()
                .body(transactionService.findAll()
                        .map(customer -> transactionMapper.entityToModel(customer))));
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<TransactionModel>> getById(@PathVariable String id){
        log.info("getById executed {}", id);
        Mono<Transaction> response = transactionService.findById(id);
        return response
                .map(customer -> transactionMapper.entityToModel(customer))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<TransactionModel>> create(@Valid @RequestBody TransactionModel
                                                            request){
        log.info("create executed {}", request);
        return transactionService.create(transactionMapper.modelToEntity(request))
                .map(customer -> transactionMapper.entityToModel(customer))
                .flatMap(c ->
                        Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name,
                                        port, "customer", c.getId())))
                                .body(c)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<TransactionModel>> updateById(@PathVariable String id, @Valid
    @RequestBody TransactionModel request){
        log.info("updateById executed {}:{}", id, request);
        return transactionService.update(id, transactionMapper.modelToEntity(request))
                .map(customer -> transactionMapper.entityToModel(customer))
                .flatMap(c ->
                        Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name,
                                        port, "customer", c.getId())))
                                .body(c)))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable String id){
        log.info("deleteById executed {}", id);
        return transactionService.delete(id)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
