package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {
    private String name;
    private String actor;
    private int price;
    private String Director;

}
