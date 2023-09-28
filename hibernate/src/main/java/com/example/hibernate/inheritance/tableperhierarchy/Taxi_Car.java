package com.example.hibernate.inheritance.tableperhierarchy;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "taxicar")
public class Taxi_Car extends Car{
    @Column(name="farePerKm")
    private int farePerKm;

    @Column(name="available")
    private boolean available;
}
