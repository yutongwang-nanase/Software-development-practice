package com.example.demo.server.service.impl;

import com.example.demo.dao.model.Comment;
import com.example.demo.dao.repo.CommentDao;
import com.example.demo.server.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServicelmpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }

    @Override
    public List<Comment> search(Comment comment) {
        return commentDao.search(comment);
    }
}
