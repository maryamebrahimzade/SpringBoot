package com.example.hibernate.inheritance.tableperconcreteclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Contract extends Employee {
    @Column(name = "pay_per_hour")
    private float pay_per_hour;

    @Column(name = "contract_duration")
    private String contract_duration;

}
