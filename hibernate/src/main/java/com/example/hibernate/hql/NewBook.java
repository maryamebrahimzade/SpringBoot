package com.example.hibernate.hql;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NewBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @ManyToOne
    private BookCategory bookCategory;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookCategory=" + bookCategory.getBookCategory() +
                '}';
    }
}
