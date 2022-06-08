package com.coderbois.baadmin.controller;

public enum Roles {
    DATA_REGISTRATION ("dataRegistration"),
    DAMAGE_REPORT ("damageReport"),
    BUSINESS_ENGINEERING ("businessEnginering");

    private String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
