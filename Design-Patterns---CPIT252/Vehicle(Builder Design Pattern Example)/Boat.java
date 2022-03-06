package com.CodeWithShehab;

public class Boat implements VehicleInterface {

    private Vehicle boat;

    public Boat() {
        boat = new Vehicle();
    }

    @Override
    public void makeBody() {
        boat.setBody("Boat Body");
    }

    @Override
    public void makeWheels() {
        boat.setWheels("Boat HAS NO WHEELS!");
    }

    @Override
    public void makeHeadLights() {
        boat.setHeadLights("Boat Headlights");
    }

    @Override
    public void makeBackLights() {
        boat.setBackLights("Boat Backlights");
    }

    @Override
    public void makeEngine() {
        boat.setEngine("Boat Engine");
    }

    @Override
    public Vehicle getVehicle() {
        return boat;
    }
}
