package com.coderbois.baadmin.model;



public class Lease {
    private int id;
    private String leaseName;
    private double monthlyPay;
    private int carNumber;

    public Lease(){

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
}
