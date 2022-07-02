package com.zhao.pojo;

import java.util.Date;
import java.util.List;

public class Article {
    private int id;
    private String title;
    private String content;
    private Date created;
    private Date modified;
    private String categories;
    private int allow_commnet;
    private String thumbnall;
    private String author;

    private Integer hits;       // 点击量
    private Integer comments_num;  // 评论总量
    public Article() {
    }

    public Article(int id, String title, String content, Date created, Date modified,
                   int allow_commnet, String thumbnall, String author, Integer hits,
                   Integer commentsNum) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.allow_commnet = allow_commnet;
        this.thumbnall = thumbnall;
        this.author = author;
        this.hits = hits;
        this.comments_num = commentsNum;
    }

    public Article(int id, String title, String content,
                   Date created, Date modified, String categories, int allow_commnet,
                   String thumbnall, String author, Integer hits,
                   Integer comments_num) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.categories = categories;
        this.allow_commnet = allow_commnet;
        this.thumbnall = thumbnall;
        this.author = author;
        this.hits = hits;
        this.comments_num = comments_num;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getAllow_commnet() {
        return allow_commnet;
    }

    public void setAllow_commnet(int allow_commnet) {
        this.allow_commnet = allow_commnet;
    }

    public String getThumbnall() {
        return thumbnall;
    }

    public void setThumbnall(String thumbnall) {
        this.thumbnall = thumbnall;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getCommentsNum() {
        return comments_num;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.comments_num = commentsNum;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getComments_num() {
        return comments_num;
    }

    public void setComments_num(Integer comments_num) {
        this.comments_num = comments_num;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", categories='" + categories + '\'' +
                ", allow_commnet=" + allow_commnet +
                ", thumbnall='" + thumbnall + '\'' +
                ", author='" + author + '\'' +
                ", hits=" + hits +
                ", comments_num=" + comments_num +
                '}';
    }
}
