package com.zhao.mapper;

import com.zhao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    List<Comment> queryCategoriy(int id);
    int selectCount(int id);
    int insertComment(Comment comment);
    int deleteComment(int id);
}
