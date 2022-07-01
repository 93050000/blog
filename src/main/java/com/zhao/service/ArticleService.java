package com.zhao.service;

import com.github.pagehelper.PageInfo;
import com.zhao.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> queryArticle();
    Article queryById(int id);
    int insertArticle(Article article);
    PageInfo<Article> queryByName(Integer pageNum,Integer pageSize,String author);
    int update(Article article);
    int delete(int id);
    int updateHist(int hits,int id);
    PageInfo<Article> queryCategories(Integer pageNum,Integer pageSize,String categories);
    PageInfo<Article> queryTitleAndAuthor(Integer pageNum,Integer pageSize,String TitleAuthor);

     PageInfo<Article> queryArticle(Integer pageNum,Integer pageSize);
}
