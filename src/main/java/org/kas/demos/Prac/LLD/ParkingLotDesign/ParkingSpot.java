package org.kas.demos.Prac.LLD.ParkingLotDesign;

// ParkingSpot represents a single parking spot
class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public String getSpotId() { return spotId; }
    public SpotType getSpotType() { return spotType; }
    public boolean isAvailable() { return parkedVehicle == null; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }

    public void parkVehicle(Vehicle vehicle) { this.parkedVehicle = vehicle; }
    public void removeVehicle() { this.parkedVehicle = null; }
}
