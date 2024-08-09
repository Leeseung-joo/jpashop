package org.example.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    @Id@GeneratedValue
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String createdBy;
    private LocalDateTime createdDate;   //이 속성들을 상속받아 쓰고 싶음
    private String LastModifiyedBy;
    private LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private String zipCode;
}
