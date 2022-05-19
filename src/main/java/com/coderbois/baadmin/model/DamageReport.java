package com.coderbois.baadmin.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Troels oprettet klassen og tilføjet constructor og attributter
public class DamageReport {

    private int id;
    private List<Damage> damage;
    private double totalCost;
    private int carNumber;

    private LocalDate warningDate;

    public DamageReport(){}

    public void addDamage(Damage damage){
        this.damage.add(damage);

    }

    public String getWarningDateAsString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return this.warningDate.format(dateTimeFormatter);
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
}
