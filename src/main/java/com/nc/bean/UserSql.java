package com.nc.bean;

public class UserSql {
    private String id;
    private String username;
    private String address;

    public UserSql() {
    }

    public UserSql(String id, String username, String address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserSql{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
