package com.group19.comment.g19_comment.repository;

import com.group19.comment.g19_comment.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}
