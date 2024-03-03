package com.utad.apipizzas.controller;


import com.utad.apipizzas.model.Pizza;
import com.utad.apipizzas.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public ResponseEntity<Pizza> savePizza(@RequestBody Pizza pizza) {
        Pizza newPizza = pizzaService.save(pizza);
        return ResponseEntity.ok(newPizza);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getAll() {
        List<Pizza> pizzaList = pizzaService.getPizzas();
        return ResponseEntity.ok(pizzaList);
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<Optional<Pizza>> getById(@PathVariable Long idPizza) {
        Optional<Pizza> pizza = pizzaService.getPizza(idPizza);
        if (pizza.isPresent())
            return ResponseEntity.ok(pizza);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pizza>> searchPizza(@RequestParam String name) {
        List<Pizza> pizzas = pizzaService.searchByName(name);
        return ResponseEntity.ok(pizzas);
    }

    @PutMapping("/{idPizza}")
    public ResponseEntity<?> updatePizza(@PathVariable Long idPizza, @RequestBody Pizza pizza) {
        boolean updated = pizzaService.updatePizza(idPizza, pizza);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Optional<Pizza>> deletePizza(@PathVariable Long idPizza) {
        pizzaService.deletePizza(idPizza);
        return ResponseEntity.ok().build();
    }

}
