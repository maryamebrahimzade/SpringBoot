package com.example.hibernate.fetchingstrategy.eager;

import com.example.hibernate.fetchingstrategy.lazi.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "employee_id")
    private Employee employee;
}
