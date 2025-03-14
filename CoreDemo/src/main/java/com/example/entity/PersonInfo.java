package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo extends Person {

    @Column(name = "contact")
    private long contact;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

}
