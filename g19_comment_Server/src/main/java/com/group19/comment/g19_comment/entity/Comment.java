package com.group19.comment.g19_comment.entity;

import lombok.*;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private @NonNull
    Long cmid;
    private @NonNull
    String text;
    private @NonNull
    Long rating;
    private String img;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mid")
    private Member members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rid")
    private Restaurant restaurants;

    public Comment() {
    }

    public Comment(String text, Long rating, String img) {
        this.text = text;
        this.rating = rating;
        this.img = img;
    }

}
