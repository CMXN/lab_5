package com.example.lab_5;

import javafx.collections.*;
import javafx.scene.control.*;

public class Owner {
    public int ownerID;
    public String name;
    public String address;
    public String phone;
    public String email;

    public Owner(int ownerID, String name, String address, String phone, String email) {
        this.ownerID = ownerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
