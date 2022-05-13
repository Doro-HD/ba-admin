package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Lease;

import java.util.ArrayList;

public class LeasingStatistic {


    private ArrayList<Lease> leases;
    private double totalPayout;
    private int totalLeases;

    public LeasingStatistic(ArrayList<Lease> leases, double totalPayout, int totalLeases){
        this.leases = leases;
        this.totalPayout = totalPayout;
        this.totalLeases = totalLeases;
    }




    public ArrayList<Lease> getLeases() {
        return leases;
    }

    public double getTotalPayout() {
        return totalPayout;
    }

    public int getTotalLeases() {
        return totalLeases;
    }


    public void setLeases(ArrayList<Lease> leases) {
        this.leases = leases;
    }

    public void setTotalPayout(double totalPayout) {
        this.totalPayout = totalPayout;
    }

    public void setTotalLeases(int totalLeases) {
        this.totalLeases = totalLeases;
    }




}
