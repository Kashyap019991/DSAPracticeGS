package org.kas.demos.Prac.LLD.ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;
    private ConcurrentHashMap<String, Ticket> activeTickets;

    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) {
                spot.parkVehicle(vehicle);
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, spot);
                activeTickets.put(ticketId, ticket);
                return ticket;
            }
        }
        return null; // Parking is full
    }

    public void unparkVehicle(Ticket ticket) {
        Ticket storedTicket = activeTickets.get(ticket.getTicketId());
        if (storedTicket != null) {
            ParkingSpot spot = storedTicket.getSpot();
            spot.removeVehicle();
            activeTickets.remove(ticket.getTicketId());
        }
    }

    public Ticket getActiveTicket(String ticketId) {
        return activeTickets.get(ticketId);
    }
}

class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && vehicle.canFit(spot)) {
                return spot;
            }
        }
        return null;
    }
}
