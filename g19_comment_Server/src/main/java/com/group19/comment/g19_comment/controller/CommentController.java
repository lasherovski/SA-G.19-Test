package com.group19.comment.g19_comment.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group19.comment.g19_comment.entity.Comment;
import com.group19.comment.g19_comment.entity.Restaurant;
import com.group19.comment.g19_comment.repository.CommentRepository;
import com.group19.comment.g19_comment.repository.MemberRepository;
import com.group19.comment.g19_comment.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/comment/create/{rid}/{username}")
    public Comment createComment(@PathVariable Long rid,@PathVariable String username,
                                 @RequestBody String dataComment)throws JsonParseException,IOException {

        final String decoded = URLDecoder.decode(dataComment, "UTF-8");
        dataComment = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataComment);

        JsonNode jsonText = actualObj.get("textSelect");
        JsonNode jsonImg = actualObj.get("imgSelect");
        JsonNode jsonRating = actualObj.get("ratingSelect");


        Comment comment = new Comment();

        comment.setRestaurants(restaurantRepository.getOne(rid));
        comment.setMembers(memberRepository.findByUsername(username));
        comment.setText(jsonText.textValue());
        comment.setRating(jsonRating.asLong());
        comment.setImg(jsonImg.textValue());
        return commentRepository.save(comment);

    }


    @GetMapping("commentbyrid/{rid}")
    public List<Comment> showCommentByRid(@PathVariable Long rid) {
        return commentRepository.findByRestaurants_Rid(rid);
    }


    @GetMapping("/comments")

    public List<Comment> showAllComment() {

        return commentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/restaurants/{rid}")
    public Restaurant ShowRestaurantInfo(@PathVariable Long rid) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
        return restaurant.get();
    }

    @DeleteMapping("/comment/delete/{cmid}")
    public void deleteComment(@PathVariable long cmid) {
        commentRepository.deleteById(cmid);
    }

}



