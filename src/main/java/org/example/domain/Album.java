package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Album extends Item{
    private String name;
    private int Price;
    private String Artist;
}
