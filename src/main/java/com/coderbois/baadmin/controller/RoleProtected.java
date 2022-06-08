package com.coderbois.baadmin.controller;

public interface RoleProtected {

    boolean hasCorrectRole(String userRole);
}
