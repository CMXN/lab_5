package com.example.lab_5;

public class Car {
    public int carID;
    public String make;
    public String model;
    public int VIN;
    public int buildYear;
    public String type;

    public Car(int carID, String make, String model, int VIN, int buildYear, String type) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.VIN = VIN;
        this.buildYear = buildYear;
        this.type = type;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
