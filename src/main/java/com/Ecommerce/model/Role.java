package com.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private RoleType roleType;
    @ManyToMany(mappedBy = "roleList")
    @JsonIgnoreProperties("roleList")
    private List<User> userList;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public List<User> getUserList() {
        if (this.userList == null) {
            this.userList = new ArrayList<>();
        }

        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role: " + "id = " + id + "; roleType = " + roleType + "; userList = " + userList + ".";
    }
}