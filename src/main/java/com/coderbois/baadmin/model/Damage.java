package com.coderbois.baadmin.model;

public class Damage {

    private String damageType;
    private int price;

    public Damage() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
}
