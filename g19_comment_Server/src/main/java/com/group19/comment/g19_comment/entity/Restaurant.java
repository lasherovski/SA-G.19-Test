package com.group19.comment.g19_comment.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Restaurants")

public class Restaurant {
    @Id
    @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    private @NonNull
    Long rid;
    private @NonNull
    String address;
    private @NonNull
    String restaurantName;
    private @NonNull
    String restaurantImg;
/*
    @OneToMany(
            mappedBy="restaurants", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();*/


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "cid", insertable = true)
    private Category categories;

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String address, String restaurantImg) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.restaurantImg = restaurantImg;
    }
}
