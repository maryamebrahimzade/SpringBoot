package com.example.hibernate.cashing;

import com.example.hibernate.hql.BookCategory;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Book {
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
