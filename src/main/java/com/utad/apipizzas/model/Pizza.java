package com.utad.apipizzas.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pizza_menu")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String restaurant;
    private Integer price;
}
