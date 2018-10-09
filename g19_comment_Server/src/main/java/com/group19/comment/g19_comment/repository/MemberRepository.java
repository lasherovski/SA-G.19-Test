package com.group19.comment.g19_comment.repository;

import com.group19.comment.g19_comment.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUsername(String username);
}
