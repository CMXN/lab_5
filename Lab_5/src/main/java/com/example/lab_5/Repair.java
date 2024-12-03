package com.example.lab_5;

import javafx.collections.*;
import javafx.scene.control.*;
import oracle.sql.*;

public class Repair {
    public int repairID;
    public int ownerID;
    public int carID;

    public Repair(int ownerID, int repairID, int carID, DATE repairDate, int cost) {
        this.ownerID = ownerID;
        this.repairID = repairID;
        this.carID = carID;
        this.repairDate = repairDate;
        this.cost = cost;
    }

    public int getRepairID() {
        return repairID;
    }

    public void setRepairID(int repairID) {
        this.repairID = repairID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public DATE getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(DATE repairDate) {
        this.repairDate = repairDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public DATE repairDate;
    public int cost;
}
