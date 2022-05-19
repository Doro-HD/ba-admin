package com.coderbois.baadmin.model;


import java.time.LocalDate;

public class Lease {
    private int id;
    private String leaseName;
    private double monthlyPay;
    private int carNumber;
    private LocalDate leaseDuration;
    private int amountOfMonths;
    private String stringDate;


    public Lease(){
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }


    public int getAmountOfMonths() {
        return amountOfMonths;
    }

    public void setAmountOfMonths(int amountOfMonths) {
        this.amountOfMonths = amountOfMonths;
    }

    public void setLeaseDuration(LocalDate leaseDuration) {
        this.leaseDuration = leaseDuration;
    }
    public LocalDate getLeaseDuration() {
        return leaseDuration;
    }

    public Lease(String leaseName, double monthlyPay, int carNumber){
        this.leaseName = leaseName;
        this. monthlyPay = monthlyPay;
        this.carNumber = carNumber;
    }


    public Lease(int id, String leaseName, double monthlyPay, int carNumber){
        this.id = id;
        this.leaseName = leaseName;
        this. monthlyPay = monthlyPay;
        this.carNumber = carNumber;
    }


    public String getLeaseName() {
        return leaseName;
    }



    public double getMonthlyPay() {
        return monthlyPay;
    }


    public int getCarNumber() {
        return carNumber;
    }

}
