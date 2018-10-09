package com.group19.comment.g19_comment;

import com.group19.comment.g19_comment.entity.Category;
import com.group19.comment.g19_comment.entity.Comment;
import com.group19.comment.g19_comment.entity.Member;
import com.group19.comment.g19_comment.entity.Restaurant;
import com.group19.comment.g19_comment.repository.CategoryRepository;
import com.group19.comment.g19_comment.repository.CommentRepository;
import com.group19.comment.g19_comment.repository.MemberRepository;
import com.group19.comment.g19_comment.repository.RestaurantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class G19CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(G19CommentApplication.class, args);
    }

    @Bean
    ApplicationRunner init(MemberRepository memberrepository, CategoryRepository categoryRepository,
                           RestaurantRepository restaurantRepository, CommentRepository commentRepository
    ) {
        return args -> {

            // set member

            Stream.of("Ms.Somsri", "Mr.Somchai","Copter").forEach(username -> {
                Member member = new Member();
                member.setUsername(username);
                memberrepository.save(member);
            });
            memberrepository.findAll().forEach(System.out::println);

            // set category

            Stream.of("Rice", "Grill").forEach(categoryName -> {
                Category category = new Category();
                category.setCategoryName(categoryName);
                categoryRepository.save(category);
            });
            categoryRepository.findAll().forEach(System.out::println);

            // set restaurant

            Stream.of("KorKok", "KaoGang").forEach(restaurantName -> {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(restaurantName);
                restaurantRepository.save(restaurant);

                if (restaurantName == "KorKok") {
                    restaurant.setAddress("SUT GATE 1");
                    restaurant.setRestaurantImg("korkok.jpg");
                    restaurant.setCategories(categoryRepository.getOne(2L));
                    restaurantRepository.save(restaurant);
                } else if (restaurantName == "KaoGang") {
                    restaurant.setAddress("SUT GATE 4");
                    restaurant.setRestaurantImg("ricegang.jpg");
                    restaurant.setCategories(categoryRepository.getOne(1L));
                    restaurantRepository.save(restaurant);
                }
            });
            restaurantRepository.findAll().forEach(System.out::println);

            //set comment
            Comment comment = new Comment();
            comment.setMembers(memberrepository.getOne(1L));
            comment.setRating(5L);
            comment.setImg("cat.jpg");
            comment.setText("Somsri First Comment for KorKok :)");
            comment.setRestaurants(restaurantRepository.getOne(1L));
            commentRepository.save(comment);

            Comment comment2 = new Comment();
            comment2.setMembers(memberrepository.getOne(2L));
            comment2.setRating(3L);
            comment2.setImg("dog.jpg");
            comment2.setText("Somchai Firsts Comment for KorKok >,<");
            comment2.setRestaurants(restaurantRepository.getOne(1L));
            commentRepository.save(comment2);
            commentRepository.findAll().forEach(System.out::println);

            Comment comment3 = new Comment();
            comment3.setMembers(memberrepository.getOne(2L));
            comment3.setRating(4L);
            comment3.setImg("fox.jpg");
            comment3.setText("Somchai Second Comment for KaoGang :D");
            comment3.setRestaurants(restaurantRepository.getOne(2L));
            commentRepository.save(comment3);
            commentRepository.findAll().forEach(System.out::println);

            Comment comment4 = new Comment();
            comment4.setMembers(memberrepository.getOne(1L));
            comment4.setRating(5L);
            comment4.setImg("apple.jpg");
            comment4.setText("Somsri Second Comment for KaoGang :<");
            comment4.setRestaurants(restaurantRepository.getOne(2L));
            commentRepository.save(comment4);
        };
    }
}
