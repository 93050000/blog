package com.zhao.mapper;

import com.zhao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    List<Article> queryArticle();
    Article queryById(int id);
    int insertArticle(Article article);
    List<Article> queryByName(String author);
    int update(Article article);
    int delete(int id);

    List<Article> queryCategories(String categories);
    int updateHist(int hits,int id);


    List<Article> queryTitleAndAuthor(String TitleAuthor);


}
