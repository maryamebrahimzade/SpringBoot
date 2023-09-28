package com.example.hibernate.inheritance.tableperhierarchy;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "sportscar")
public class Sports_Car extends Car{
    @Column(name="mileage")
    private int mileage;

    @Column(name="cost")
    private int cost;
}
