package com.zhao.pojo;

public class User {

    private int id;
    private String username;
    private String name;
    private String password;
    private int valid;

    public User(int id, String username, String name, String password, int valid) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.valid = valid;
    }

    public User(int id, String name, String password, int valid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.valid = valid;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", valid=" + valid +
                '}';
    }
}
