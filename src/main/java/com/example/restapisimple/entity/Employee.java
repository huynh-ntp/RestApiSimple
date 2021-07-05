package com.example.restapisimple.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tblEmployee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;


}
