package com.CodeWithShehab;

public class Car implements VehicleInterface {

    private Vehicle car;

    public Car() {
        car = new Vehicle();
    }

    @Override
    public void makeBody() {
        car.setBody("Car Body");
    }

    @Override
    public void makeWheels() {
        car.setWheels("Car wheels");
    }

    @Override
    public void makeHeadLights() {
        car.setHeadLights("Car Headlights");
    }

    @Override
    public void makeBackLights() {
        car.setBackLights("Car Backlights");
    }

    @Override
    public void makeEngine() {
        car.setEngine("Car Engine");
    }

    @Override
    public Vehicle getVehicle() {
        return car;
    }
}
