package com.CodeWithShehab;

public class Truck implements VehicleInterface {
    private Vehicle truck;

    public Truck() {
        truck = new Vehicle();
    }

    @Override
    public void makeBody() {
        truck.setBody("Truck Body");
    }

    @Override
    public void makeWheels() {
        truck.setWheels("Truck wheels");
    }

    @Override
    public void makeHeadLights() {
        truck.setHeadLights("Truck Headlights");
    }

    @Override
    public void makeBackLights() {
        truck.setBackLights("Truck Backlights");
    }

    @Override
    public void makeEngine() {
        truck.setEngine("Truck Engine");
    }

    @Override
    public Vehicle getVehicle() {
        return truck;
    }
}
