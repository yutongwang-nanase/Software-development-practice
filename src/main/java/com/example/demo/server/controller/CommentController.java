package com.example.demo.server.controller;

import com.example.demo.dao.model.Comment;
import com.example.demo.server.service.impl.CommentServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServicelmpl commentServicelmpl;

    @PostMapping
    public int insert(@RequestBody Comment comment){
        return commentServicelmpl.insert(comment);
    }


    @PostMapping("/search")
    public List<Comment> search(@RequestBody Comment comment){
        return commentServicelmpl.search(comment);
    }

}
