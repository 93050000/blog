package com.zhao.pojo;

import java.util.Date;

public class Comment {
    private int id;
    private int article_id;
    private Date created;
    private String ip;
    private String content;
    private String status;
    private String author;

    public Comment() {
    }

    public Comment(int id, int article_id, Date created, String ip, String text, String status, String author) {
        this.id = id;
        this.article_id = article_id;
        this.created = created;
        this.ip = ip;
        this.content = text;
        this.status = status;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", created=" + created +
                ", ip='" + ip + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", author='" + author + '\'' +
                '}';
    }
}
