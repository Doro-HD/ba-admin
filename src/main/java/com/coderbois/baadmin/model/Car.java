package com.coderbois.baadmin.model;

//Author
//Lasse
public class Car {

      private int carId;
      private String chassisNumber;
      private CarState carState;
      private String carBrand;
      private String carModel;
      private int carYear;

      public Car (){

      }

      public Car (int carId, String chassisNumber){
            this.carId = carId;
            this.chassisNumber = chassisNumber;
      }

      public Car (int carId, String chassisNumber, CarState carState) {
            this.carId = carId;
            this.chassisNumber = chassisNumber;
            this.carState = carState;
      }

      public int getCarId() {
            return carId;
      }

      public void setCarId(int carId) {
            this.carId = carId;
      }

      public String getChassisNumber() {
            return chassisNumber;
      }

      public void setChassisNumber(String chassisNumber) {
            this.chassisNumber = chassisNumber;
      }

      public CarState getCarState() {
            return carState;
      }

      public void setCarState(CarState carState) {
            this.carState = carState;
      }



      public String getCarBrand() {
            return carBrand;
      }

      public void setCarBrand(String carBrand) {
            this.carBrand = carBrand;
      }

      public String getCarModel() {
            return carModel;
      }

      public void setCarModel(String carModel) {
            this.carModel = carModel;
      }

      public int getCarYear() {
            return carYear;
      }

      public void setCarYear(int carYear) {
            this.carYear = carYear;
      }


}


