package com.CodeWithShehab;

public class VehicleBuilder {
    private VehicleInterface vehicle;

    public VehicleBuilder(VehicleInterface vehicle) {
        this.vehicle = vehicle;
    }

    public void makeVehicle() {
        vehicle.makeBackLights();
        vehicle.makeBody();
        vehicle.makeEngine();
        vehicle.makeWheels();
        vehicle.makeHeadLights();
    }

    public Vehicle getVehicle() {
        return vehicle.getVehicle();
    }
}
