package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    @Query("SELECT f FROM Vegetable f ORDER BY f.price ASC")
    List<Vegetable> getByPriceAsc();

    @Query("SELECT f FROM Vegetable f ORDER BY f.price DESC")
    List<Vegetable> getByPriceDesc();

    @Query("SELECT v FROM Vegetable v WHERE v.name LIKE %:name%")
    List<Vegetable> searchByName(@Param("name") String name);
}
