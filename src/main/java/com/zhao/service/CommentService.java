package com.zhao.service;

import com.zhao.mapper.CommentMapper;
import com.zhao.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> queryCategoriy(int id);
    int selectCount(int id);
    int insertComment(Comment comment);
    int deleteComment(int id);
}
