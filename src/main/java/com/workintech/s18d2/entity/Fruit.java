package com.workintech.s18d2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fruit", schema = "fsweb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit extends Plant{

    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType fruitType;

}
