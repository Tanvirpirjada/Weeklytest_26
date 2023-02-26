package com.example.Student_management_System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.IntegralDataTypeHolder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_tbl")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;
}

