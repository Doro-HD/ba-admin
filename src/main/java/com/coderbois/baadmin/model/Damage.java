package com.coderbois.baadmin.model;

//Author
//David
//Troels
public class Damage {

    private String damageType;
    private double price;

    public Damage() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
}
