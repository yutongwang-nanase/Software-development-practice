package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.CommentMapper;
import com.example.demo.dao.mapper.EvaMapper;
import com.example.demo.dao.model.Comment;
import com.example.demo.dao.model.Eva;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class CommentDao  extends ServiceImpl<CommentMapper, Comment> {

    @Resource
    CommentMapper commentMapper;

    public List<Comment> search(Comment comment) {
        return commentMapper.selectgoods(comment.getProductId());
    }

    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }
}
