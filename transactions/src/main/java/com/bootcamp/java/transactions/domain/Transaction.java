package com.bootcamp.java.transactions.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Data//genera get y set
@Builder//
@ToString//permite generar to String
@EqualsAndHashCode(of = {"identityNumber"})//permite comparacion
@AllArgsConstructor//constructor vacio con todas las propiedades
@NoArgsConstructor//
@Document(value = "credit")
public class Transaction {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)//valores unicos
    private String identityNumber;
    @NotNull
    private LocalDate dateTransaction;
    @NotNull
    private String idClient;
    @NotNull
    private String idProduct;
    @NotNull
    private String detail;
    @NotNull
    private String type;
    @NotNull
    private String amount;
    @NotNull
    private String status;
}
