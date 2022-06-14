package com.coderbois.baadmin.model;

import java.time.LocalDate;

//Author
//Lasse
//Victor
public class Lease implements Comparable<Lease>{
    private int id;

    private String leaseName;
    private double monthlyPay;
    private int carNumber;
    private LocalDate leaseDuration;
    private int amountOfMonths;
    private String stringDate;
    private String localDate;



    public Lease(String leaseName, double monthlyPay, int carNumber, int amountOfMonths){
        this.leaseName = leaseName;
        this. monthlyPay = monthlyPay;
        this.carNumber = carNumber;
        this.amountOfMonths = amountOfMonths;
    }


    public Lease(int id, String leaseName, double monthlyPay, int carNumber, LocalDate leaseDuration){
        this.id = id;
        this.leaseName = leaseName;
        this. monthlyPay = monthlyPay;
        this.carNumber = carNumber;
        this.leaseDuration = leaseDuration;
    }

    public Lease(){
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeaseName() {
        return leaseName;
    }

    public void setLeaseName(String leaseName) {
        this.leaseName = leaseName;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public LocalDate getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(LocalDate leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public int getAmountOfMonths() {
        return amountOfMonths;
    }

    public void setAmountOfMonths(int amountOfMonths) {
        this.amountOfMonths = amountOfMonths;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @Override
    public int compareTo(Lease o) { // Taget fra hjemmesiden geeksforgeeks.org
        if (this.getLeaseDuration() == null || o.getLeaseDuration() == null)
            return 0;
        return this.getLeaseDuration().compareTo(o.getLeaseDuration());
    }

}

