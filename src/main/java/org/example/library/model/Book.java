package org.example.library.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @Column(unique = true)
    private Integer isbn;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    private Integer amountAvailable;

    @Override
    public String toString() {
        return "Title= " + title + '\'' +
                ", isbn= " + isbn +
                ", author= " + author +
                ", category= " + category +
                ", amountAvailable= " + amountAvailable + ".\n";
    }

    public String toMapString() {
        return title + " - " + author.getName();
    }
}
