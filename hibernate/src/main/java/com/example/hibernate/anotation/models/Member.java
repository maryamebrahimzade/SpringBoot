package com.example.hibernate.anotation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    private Integer id;
    private String name;
    private String family;
    private String nationalCode;
    @Lob
    @Column(columnDefinition="CLOB")
    private String details;
}
