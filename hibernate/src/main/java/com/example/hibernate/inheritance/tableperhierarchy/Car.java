package com.example.hibernate.inheritance.tableperhierarchy;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value = "car")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
}
