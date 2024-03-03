package com.utad.apipizzas.service;


import com.utad.apipizzas.model.Pizza;
import com.utad.apipizzas.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizza(Long id) {
        return pizzaRepository.findById(id);
    }

    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }

    public List<Pizza> searchByName(String name) {
        return pizzaRepository.findByNameContainingIgnoreCase(name);
    }

    public boolean updatePizza(Long id, Pizza pizzaDetails) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);

        if (pizzaOptional.isPresent()) {
            Pizza pizzaToUpdate = pizzaOptional.get();
            pizzaToUpdate.setName(pizzaDetails.getName());
            pizzaToUpdate.setRestaurant(pizzaDetails.getRestaurant());
            pizzaToUpdate.setPrice(pizzaDetails.getPrice());

            pizzaRepository.save(pizzaToUpdate);
            return true;
        } else {
            return false;
        }
    }
}
