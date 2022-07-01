package com.zhao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhao.mapper.ArticleMapper;
import com.zhao.mapper.UserMapper;
import com.zhao.pojo.Article;
import com.zhao.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> queryArticle() {
        return articleMapper.queryArticle();
    }

    @Override
    public Article queryById(int id) {
        return articleMapper.queryById(id);
    }

    @Override
    public int insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public PageInfo<Article> queryByName(Integer pageNum,Integer pageSize,String author) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.queryByName(author);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return pageInfo;
    }

    @Override
    public int update(Article article) {
        return articleMapper.update(article);
    }

    @Override
    public int delete(int id) {
        return articleMapper.delete(id);
    }

    @Override
    public int updateHist(int hits, int id) {
        return articleMapper.updateHist(hits,id);
    }

    @Override
    public PageInfo<Article> queryCategories(Integer pageNum,Integer pageSize,String categories) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.queryCategories(categories);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return pageInfo;
    }

    @Override
    public PageInfo<Article> queryTitleAndAuthor(Integer pageNum,Integer pageSize,String TitleAuthor) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.queryTitleAndAuthor(TitleAuthor);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return pageInfo;
    }

    @Override
    public PageInfo<Article> queryArticle( Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.queryArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return pageInfo;
    }
}
