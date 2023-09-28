package com.example.hibernate.hql;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookCategory;
    @OneToMany(mappedBy = "bookCategory")
    private List<Book> books;
}
