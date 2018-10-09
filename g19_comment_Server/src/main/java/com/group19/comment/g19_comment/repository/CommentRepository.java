package com.group19.comment.g19_comment.repository;

import com.group19.comment.g19_comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByRestaurants_Rid(Long rid);
}
