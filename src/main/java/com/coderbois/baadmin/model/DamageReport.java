package com.coderbois.baadmin.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Troels oprettet klassen og tilføjet constructor og attributter
public class DamageReport {

    private int id;
    private ArrayList<Damage> damages;
    private double totalCost;
    private int carNumber;
    private int listSize;


    private LocalDate warningDate;

    public DamageReport() {
        this.damages = new ArrayList<>();
    }

    public void addDamage(Damage damage) {
        this.damages.add(damage);
        this.listSize++;
    }

    public String getWarningDateAsString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return this.warningDate.format(dateTimeFormatter);
    }

    public ArrayList<Damage> getDamage() {
        return damages;
    }

    public void setDamage(ArrayList<Damage> damage) {
        this.damages = damage;
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

    public String getWarningDate() {
        return warningDate.toString();
    }

    public void setWarningDate(LocalDate warningDate) {
        this.warningDate = warningDate;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getListSize() {
        return listSize;
    }
}
