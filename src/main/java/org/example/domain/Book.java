package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book{
    @Id@GeneratedValue
    private String name;
    private int price;
    private String Author;
    private String Isbn;
}
