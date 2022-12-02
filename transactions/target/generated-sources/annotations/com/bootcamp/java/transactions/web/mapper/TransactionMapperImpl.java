package com.bootcamp.java.transactions.web.mapper;

import com.bootcamp.java.transactions.domain.Transaction;
import com.bootcamp.java.transactions.web.model.TransactionModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-02T15:22:53-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction modelToEntity(TransactionModel model) {
        if ( model == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.id( model.getId() );
        transaction.identityNumber( model.getIdentityNumber() );
        transaction.name( model.getName() );
        transaction.lastName( model.getLastName() );
        transaction.businessName( model.getBusinessName() );
        transaction.email( model.getEmail() );
        transaction.phoneNumber( model.getPhoneNumber() );
        transaction.birthday( model.getBirthday() );
        transaction.type( model.getType() );

        return transaction.build();
    }

    @Override
    public TransactionModel entityToModel(Transaction event) {
        if ( event == null ) {
            return null;
        }

        TransactionModel.TransactionModelBuilder transactionModel = TransactionModel.builder();

        transactionModel.id( event.getId() );
        transactionModel.identityNumber( event.getIdentityNumber() );
        transactionModel.name( event.getName() );
        transactionModel.lastName( event.getLastName() );
        transactionModel.businessName( event.getBusinessName() );
        transactionModel.email( event.getEmail() );
        transactionModel.phoneNumber( event.getPhoneNumber() );
        transactionModel.birthday( event.getBirthday() );
        transactionModel.type( event.getType() );

        return transactionModel.build();
    }

    @Override
    public void update(Transaction entity, Transaction updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setIdentityNumber( updateEntity.getIdentityNumber() );
        entity.setName( updateEntity.getName() );
        entity.setLastName( updateEntity.getLastName() );
        entity.setBusinessName( updateEntity.getBusinessName() );
        entity.setEmail( updateEntity.getEmail() );
        entity.setPhoneNumber( updateEntity.getPhoneNumber() );
        entity.setBirthday( updateEntity.getBirthday() );
        entity.setType( updateEntity.getType() );
    }
}
