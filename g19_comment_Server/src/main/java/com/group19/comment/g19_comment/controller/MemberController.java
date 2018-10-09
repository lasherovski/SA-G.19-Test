package com.group19.comment.g19_comment.controller;


import com.group19.comment.g19_comment.entity.Member;
import com.group19.comment.g19_comment.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> showAllMember() {
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }
}