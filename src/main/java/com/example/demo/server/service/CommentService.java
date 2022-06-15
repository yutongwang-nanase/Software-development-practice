package com.example.demo.server.service;

import com.example.demo.dao.model.Comment;

import java.util.List;

public interface CommentService {
    int insert(Comment comment);

    List<Comment> search(Comment comment);
}
