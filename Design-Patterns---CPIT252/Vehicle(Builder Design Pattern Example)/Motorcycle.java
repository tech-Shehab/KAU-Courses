package com.CodeWithShehab;

public class Motorcycle implements VehicleInterface{

    private Vehicle bike;

    public Motorcycle() {
        bike = new Vehicle();
    }

    @Override
    public void makeBody() {
        bike.setBody("Motorcycle body");
    }

    @Override
    public void makeWheels() {
        bike.setWheels("Motorcycle wheels");
    }

    @Override
    public void makeHeadLights() {
        bike.setHeadLights("Motorcycle Headlights");
    }

    @Override
    public void makeBackLights() {
        bike.setBackLights("Motorcycle Backlights");
    }

    @Override
    public void makeEngine() {
        bike.setEngine("Motorcycle Engine");
    }

    @Override
    public Vehicle getVehicle() {
        return bike;
    }
}
