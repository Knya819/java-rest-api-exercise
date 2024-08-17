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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Use AUTO strategy to let the database handle UUID generation

    private String borrower;
    private String lender;
    private BigDecimal amount;
    private Instant dateTime;

    // Define a default UUID
    private static final UUID DEFAULT_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    // Custom getter for id with default UUID logic
    public UUID getId() {
        return id != null ? id : DEFAULT_UUID;
    }
}
