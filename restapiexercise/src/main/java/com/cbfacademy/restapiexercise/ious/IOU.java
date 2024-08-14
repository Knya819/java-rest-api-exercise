package com.cbfacademy.restapiexercise.ious;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table

public class IOU {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;
    private String borrower;
    private String lender;
    private BigDecimal amount;
    private Instant dateTime;


    public IOU(){
        }

    public IOU( UUID id,
         String borrower,
         String lender,
         BigDecimal amount,
         Instant dateTime){
            this.id = id;
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
            this.dateTime = dateTime;
         }

         public IOU(
         String borrower,
         String lender,
         BigDecimal amount,
         Instant dateTime){
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
            this.dateTime = dateTime;
         }

         };






}
