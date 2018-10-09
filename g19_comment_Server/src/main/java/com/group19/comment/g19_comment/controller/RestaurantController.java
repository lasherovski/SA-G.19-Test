package com.group19.comment.g19_comment.controller;

import com.group19.comment.g19_comment.entity.Restaurant;
import com.group19.comment.g19_comment.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> showAllRestaurant() {
        return restaurantRepository.findAll().stream().collect(Collectors.toList());
    }
}
