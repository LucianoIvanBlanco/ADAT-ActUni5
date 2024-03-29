package com.utad.apipizzas.repository;


import com.utad.apipizzas.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {


    List<Pizza> findByNameContainingIgnoreCase(String name);
}
