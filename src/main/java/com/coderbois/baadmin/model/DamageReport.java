package com.coderbois.baadmin.model;

import java.util.List;

//Troels oprettet klassen og tilføjet constructor og attributter
public class DamageReport {

    private int id;
    private List<Damage> damage;
    private double totalCost;
    private int carNumber;

    public DamageReport(){}

    public boolean addDamage(Damage damage){


        return false;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
