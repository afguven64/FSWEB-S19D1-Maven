package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        return vegetableRepository.findById(id).orElseThrow(
                () -> new PlantException(("Vegetable with id " + id + " not found"),
                        HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Vegetable> searchByName(String fruitName) {
        return vegetableRepository.searchByName(fruitName);
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable fruit) {
        return vegetableRepository.save(fruit);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetableToDelete = findById(id);
        vegetableRepository.delete(vegetableToDelete);
        return vegetableToDelete;
    }

}
