package com.group19.comment.g19_comment.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Categories")

public class Category {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private @NonNull
    Long cid;
    private @NonNull
    String categoryName;

    /*
        @OneToMany(
                mappedBy="categories",cascade = CascadeType.ALL)
        private List<Restaurant> restaurants = new ArrayList<>();
    */
    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
