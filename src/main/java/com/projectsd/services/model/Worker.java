package com.projectsd.services.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="WORKERS")
public class Worker extends User{
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable = true)
    private Customer customer;

    public Worker(String firstName, String lastName, String email, String phoneNumber, Integer age) {
        super(firstName, lastName, email, phoneNumber, age);
    }

    public Worker(String firstName, String lastName, String email, String phoneNumber, Integer age, Customer customer) {
        super(firstName, lastName, email, phoneNumber, age);
        this.customer = customer;
    }
}
