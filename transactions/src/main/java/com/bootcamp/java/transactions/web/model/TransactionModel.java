package com.bootcamp.java.transactions.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
    @JsonIgnore
    private String id;

    @NotBlank(message="Identity Number cannot be null or empty")
    private String identityNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateTransaction;

    @NotBlank(message="Cliente cannot be null or empty")
    private String idClient;

    @NotBlank(message="Producto cannot be null or empty")
    private String idProduct;

    @NotBlank(message="Detail cannot be null or empty")
    private String detail;

    @NotBlank(message="Type cannot be null or empty")
    private String type;

    @NotBlank(message="Amount cannot be null or empty")
    private String amount;

    @NotBlank(message="Status cannot be null or empty")
    private String status;
}
