package com.CodeWithShehab;

public class Main {

    private static VehicleInterface vehicle;
    private static VehicleBuilder builder;

    // Vehicles
    public static Vehicle car, truck, boat, bike;

    public static void main(String[] args) {
        builder = new VehicleBuilder(new Car());
        builder.makeVehicle();
        car = builder.getVehicle();

        System.out.println("***** Vehicle is Being Built *****");
        System.out.println("Vehicle body       :\t" + car.getBody());
        System.out.println("Vehicle Headlight  :\t" + car.getHeadLights());
        System.out.println("Vehicle Backlights :\t" + car.getBackLights());
        System.out.println("Vehicle Engine     :\t" + car.getEngine());
        System.out.println("Vehicle Wheels     :\t" + car.getWheels());

        builder = new VehicleBuilder(new Truck());
        builder.makeVehicle();
        truck = builder.getVehicle();

        System.out.println("\n***** Vehicle is Being Built *****");
        System.out.println("Vehicle body       :\t" + truck.getBody());
        System.out.println("Vehicle Headlight  :\t" + truck.getHeadLights());
        System.out.println("Vehicle Backlights :\t" + truck.getBackLights());
        System.out.println("Vehicle Engine     :\t" + truck.getEngine());
        System.out.println("Vehicle Wheels     :\t" + truck.getWheels());

        builder = new VehicleBuilder(new Boat());
        builder.makeVehicle();
        boat = builder.getVehicle();

        System.out.println("\n***** Vehicle is Being Built *****");
        System.out.println("Vehicle body       :\t" + boat.getBody());
        System.out.println("Vehicle Headlight  :\t" + boat.getHeadLights());
        System.out.println("Vehicle Backlights :\t" + boat.getBackLights());
        System.out.println("Vehicle Engine     :\t" + boat.getEngine());
        System.out.println("Vehicle Wheels     :\t" + boat.getWheels());

        builder = new VehicleBuilder(new Motorcycle());
        builder.makeVehicle();
        bike = builder.getVehicle();

        System.out.println("\n***** Vehicle is Being Built *****");
        System.out.println("Vehicle body       :\t" + bike.getBody());
        System.out.println("Vehicle Headlight  :\t" + bike.getHeadLights());
        System.out.println("Vehicle Backlights :\t" + bike.getBackLights());
        System.out.println("Vehicle Engine     :\t" + bike.getEngine());
        System.out.println("Vehicle Wheels     :\t" + bike.getWheels());
    }
}
