package org.kas.demos.Prac.LLD.ParkingLotDesign;

// Abstract Vehicle class
abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
    public abstract boolean canFit(ParkingSpot spot);
}

// Concrete Car class
class Car extends Vehicle {
    public Car(String licensePlate) { super(licensePlate, VehicleType.CAR); }
    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotType() == SpotType.COMPACT || spot.getSpotType() == SpotType.LARGE;
    }
}

// Concrete Motorcycle class
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) { super(licensePlate, VehicleType.MOTORCYCLE); }
    @Override
    public boolean canFit(ParkingSpot spot) {
        // A motorcycle can fit in any spot
        return true;
    }
}

// Vehicle factory to create vehicle instances
class VehicleFactory {
    public static Vehicle createVehicle(String type, String licensePlate) {
        switch (type.toUpperCase()) {
            case "CAR": return new Car(licensePlate);
            case "MOTORCYCLE": return new Motorcycle(licensePlate);
            // Add more vehicle types here
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
