package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAllFruits();
    Fruit getById(Long id);
    List<Fruit> searchByName(String fruitName);
    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();
    Fruit save(Fruit fruit);
    Fruit delete(Long id);

}
