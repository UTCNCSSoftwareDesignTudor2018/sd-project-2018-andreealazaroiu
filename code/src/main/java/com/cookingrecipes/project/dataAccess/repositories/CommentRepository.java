package com.cookingrecipes.project.dataAccess.repositories;

import com.cookingrecipes.project.dataAccess.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
