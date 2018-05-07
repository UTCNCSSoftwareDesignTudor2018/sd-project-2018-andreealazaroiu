package com.cookingrecipes.project.business;

import com.cookingrecipes.project.dataAccess.entities.Comment;
import com.cookingrecipes.project.dataAccess.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    void addComment(Comment comment)
    {
        commentRepository.save(comment);
    }

    void deleteComment(Comment comment)
    {
        commentRepository.delete(comment);
    }
}
