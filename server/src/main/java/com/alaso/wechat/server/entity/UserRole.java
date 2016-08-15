package com.alaso.wechat.server.entity;

/**
 * Created by adam on 10/1/16.
 */
public class UserRole extends BaseEntity {

    private int id;
    private User user;
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
