package com.team2.foodiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MealPlanDay> days;

}
