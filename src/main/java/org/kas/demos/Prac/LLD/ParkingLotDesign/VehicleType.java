package org.kas.demos.Prac.LLD.ParkingLotDesign;

import java.time.LocalDateTime;

// Enum for vehicle types
enum VehicleType {
    CAR, MOTORCYCLE, TRUCK
}

// Enum for parking spot types
enum SpotType {
    COMPACT, LARGE, HANDICAPPED
}

// Enum for payment status
enum PaymentStatus {
    PENDING, COMPLETED, FAILED
}

// Enum for payment types
enum PaymentType {
    CASH, CARD, UPI
}

// Data class for a parking ticket
class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public LocalDateTime getEntryTime() { return entryTime; }
}
