package com.coderbois.baadmin.model;

import java.util.List;

//Troels oprettet klassen og tilføjet constructor og attributter
public class DamageReport {

    private List<Damage> damage;
    private double totalCost;
    private int carNumber;

    public DamageReport(){}

    public boolean addDamage(){


        return false;
    }

    public List<Damage> getDamage() {
        return damage;
    }

    public void setDamage(List<Damage> damage) {
        this.damage = damage;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }
}
