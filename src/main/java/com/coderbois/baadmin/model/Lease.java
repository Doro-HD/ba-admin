package com.coderbois.baadmin.model;



public class Lease {
    private int id;
    private String leaseName;
    private double monthlyPay;
    private int carNumber;

    public Lease(){}

    public Lease(int id, String leaseName, double monthlyPay, int carNumber){
        this.id = id;
        this.leaseName = leaseName;
        this. monthlyPay = monthlyPay;
        this.carNumber = carNumber;
    }

}
