package com.zhao.pojo;

public class Categoriy {
    private int id;
    private String categories;

    public Categoriy(int id, String categories) {
        this.id = id;
        this.categories = categories;
    }

    public Categoriy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Categoriy{" +
                "id=" + id +
                ", categories='" + categories + '\'' +
                '}';
    }
}
