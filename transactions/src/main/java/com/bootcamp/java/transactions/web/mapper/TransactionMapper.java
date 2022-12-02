package com.bootcamp.java.transactions.web.mapper;

import com.bootcamp.java.transactions.domain.Transaction;
import com.bootcamp.java.transactions.web.model.TransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    //Permite crear un modelo a una entidad de dominio
    Transaction modelToEntity (TransactionModel model);
    //de un dominio a una entidad de modelo para navegar entre las capas
    TransactionModel entityToModel (Transaction event);
    //actualizar una entidad existente con otra
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Transaction entity, Transaction updateEntity);
}
