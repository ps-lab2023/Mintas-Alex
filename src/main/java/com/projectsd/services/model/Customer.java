package com.projectsd.services.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="CUSTOMER")
public class Customer extends User{

    @OneToMany(cascade = CascadeType.ALL/*, mappedBy = "customer"*/)
    /*@JoinColumn(name="workers_id", nullable = true)*/
    private List<Worker> workers;

    public Customer(String firstName, String lastName, String email, String phoneNumber, Integer age) {
        super(firstName, lastName, email, phoneNumber, age);
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, Integer age, List<Worker> workers) {
        super(firstName, lastName, email, phoneNumber, age);
        this.workers = new ArrayList<Worker>(workers);
    }
}
