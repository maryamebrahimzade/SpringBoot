package com.example.hibernate.inheritance.tableperconcreteclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Regular extends Employee {
    @Column(name = "salary")
    private float salary;

    @Column(name = "bonus")
    private int bonus;
}
