package org.kas.demos.Prac.LLD.ParkingLotDesign;

class EntryGate {
    public Ticket getParkingTicket(Vehicle vehicle) {
        System.out.println("Processing vehicle: " + vehicle.licensePlate);
        Ticket ticket = ParkingLot.getInstance().parkVehicle(vehicle);
        if (ticket != null) {
            System.out.println("Ticket issued. ID: " + ticket.getTicketId());
        } else {
            System.out.println("Parking lot is full.");
        }
        return ticket;
    }
}

class ExitGate {
    private PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(String ticketId) {
        Ticket ticket = ParkingLot.getInstance().getActiveTicket(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket.");
            return 0.0;
        }

        double fee = pricingStrategy.calculateFee(ticket);
        System.out.println("Parking fee: $" + fee);
        
        // Assume payment is successful
        ParkingLot.getInstance().unparkVehicle(ticket);
        System.out.println("Vehicle with ticket " + ticketId + " has left.");
        return fee;
    }
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        // Setup the parking lot
        ParkingLot lot = ParkingLot.getInstance();
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addParkingSpot(new ParkingSpot("F1-C1", SpotType.COMPACT));
        floor1.addParkingSpot(new ParkingSpot("F1-C2", SpotType.COMPACT));
        floor1.addParkingSpot(new ParkingSpot("F1-L1", SpotType.LARGE));
        lot.addFloor(floor1);

        // Setup gates with different pricing strategies
        EntryGate entryGate = new EntryGate();
        ExitGate hourlyExitGate = new ExitGate(new HourlyPricingStrategy());

        // A vehicle enters and gets a ticket
        Vehicle car = VehicleFactory.createVehicle("car", "XYZ-789");
        Ticket carTicket = entryGate.getParkingTicket(car);
        
        if (carTicket != null) {
            // Simulate some parking time...
            System.out.println("... car is parked ...");
            
            // The vehicle leaves and pays
            hourlyExitGate.processExit(carTicket.getTicketId());
        }
    }
}
