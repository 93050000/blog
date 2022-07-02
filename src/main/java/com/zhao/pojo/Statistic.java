package com.zhao.pojo;

public class Statistic {
    private int id ;
    private int article_id;
    private int hits;
    private int comments_num;

    public Statistic() {
    }

    public Statistic(int id, int article_id, int hits, int comments_num) {
        this.id = id;
        this.article_id = article_id;
        this.hits = hits;
        this.comments_num = comments_num;
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

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getComments_num() {
        return comments_num;
    }

    public void setComments_num(int comments_num) {
        this.comments_num = comments_num;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", hits=" + hits +
                ", comments_num=" + comments_num +
                '}';
    }
}
