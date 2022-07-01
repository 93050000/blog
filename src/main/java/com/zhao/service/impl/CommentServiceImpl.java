package com.zhao.service.impl;

import com.zhao.mapper.CommentMapper;
import com.zhao.pojo.Comment;
import com.zhao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> queryCategoriy(int id) {
        return commentMapper.queryCategoriy(id);
    }

    @Override
    public int selectCount(int id) {
        return commentMapper.selectCount(id);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int deleteComment(int id) {
        return commentMapper.deleteComment(id);
    }
}
