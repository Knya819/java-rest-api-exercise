package com.cbfacademy.restapiexercise.ious;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ious")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IOU {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; 

    private String borrower;
    private String lender;
    private BigDecimal amount;
    private Instant dateTime;


    public IOU(String borrower, 
              String lender,
              BigDecimal amount, 
              Instant dateTime) {
      this.id =UUID.randomUUID();
      this.borrower = borrower;
      this.lender = lender;
      this.amount = amount;
      this.dateTime = dateTime;
  }
  
}
