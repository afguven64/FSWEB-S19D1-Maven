package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/fruits")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getFruits() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@Positive(message = "ID must be positive") @PathVariable Long id) {
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsByDecs(){

        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit addFruit(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> getFruitByName(@Size(min=2, max=40, message= "isim 2-40 arası olmalı") @PathVariable("name") String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable("id") Long id) {
        fruitService.delete(id); 
    }
}

