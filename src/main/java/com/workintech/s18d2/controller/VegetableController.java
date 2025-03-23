package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService, VegetableRepository vegetableRepository) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getFruits() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getFruitsDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegById (@Positive(message = "id must be positive") @PathVariable long id) {
        return vegetableService.findById(id);
    }

    @PostMapping
    public Vegetable addFruit(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> getFruitByName(@Size(min=2, max=40, message= "isim 2-40 arası olmalı")
                                              @PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        vegetableService.delete(id);
    }
}
