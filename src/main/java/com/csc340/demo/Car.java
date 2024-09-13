package com.csc340.demo;

public class Car {
    public String MakeName;
    public String VehicleTypeName;

    public Car(String MakeName, String VehicleTypeName) {
        this.MakeName = MakeName;
        this.VehicleTypeName = VehicleTypeName;
    }

    public String getMakeName() {
        return MakeName;
    }

    public void setMakeName(String makeName) {
        MakeName = makeName;
    }

    public String getVehicleTypeName() {
        return VehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        VehicleTypeName = vehicleTypeName;
    }
}
