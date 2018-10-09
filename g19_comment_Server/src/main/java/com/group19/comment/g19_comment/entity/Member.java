package com.group19.comment.g19_comment.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Members")
public class Member {
    @Id
    @SequenceGenerator(name = "member_seq", sequenceName = "member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    private @NonNull
    Long mid;
    private @NonNull
    String username;

/*
    @OneToMany(
            mappedBy="members",cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();*/

    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }

}
