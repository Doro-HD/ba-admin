package com.coderbois.baadmin.controller;

//Author for this entire interface
//David
public class RoleProtected {

    private String roleName;

    public RoleProtected(String roleName) {
        this.roleName = roleName;
    }
    public boolean hasCorrectRole(String userRole) {
        return userRole.equals(this.roleName);
    }
}
