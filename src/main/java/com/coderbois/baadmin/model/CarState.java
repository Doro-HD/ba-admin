package com.coderbois.baadmin.model;


//Created by victor
public enum CarState {

    AVAILABLE ("available"),
    LEASED ("leased"),
    DAMAGED ("damage"),
    CHECKUP ("check up");

    private String name;

    CarState(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}
