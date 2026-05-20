import java.util.*;

// Base class representing a Courier
class Courier {
    private String trackingId;
    private String sender;
    private String receiver;
    private String status;

    public Courier(String trackingId, String sender, String receiver) {
        this.trackingId = trackingId;
        this.sender = sender;
        this.receiver = receiver;
        this.status = "Booked";
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("Tracking ID: " + trackingId);
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
        System.out.println("Status: " + status);
        System.out.println("---------------------------");
    }
}

// Service class to manage couriers
class CourierService {
    private Map<String, Courier> courierMap = new HashMap<>();

    // Add new courier
    public void addCourier(Courier courier) {
        courierMap.put(courier.getTrackingId(), courier);
        System.out.println("Courier added successfully!");
    }

    // Track courier
    public void trackCourier(String trackingId) {
        Courier courier = courierMap.get(trackingId);
        if (courier != null) {
            courier.displayDetails();
        } else {
            System.out.println("Courier not found!");
        }
    }

    // Update courier status
    public void updateCourierStatus(String trackingId, String status) {
        Courier courier = courierMap.get(trackingId);
        if (courier != null) {
            courier.updateStatus(status);
            System.out.println("Status updated successfully!");
        } else {
            System.out.println("Courier not found!");
        }
    }

    // Display all couriers
    public void displayAllCouriers() {
        if (courierMap.isEmpty()) {
            System.out.println("No couriers available.");
        } else {
            for (Courier c : courierMap.values()) {
                c.displayDetails();
            }
        }
    }
}

// Main class
public class CourierTrackingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourierService service = new CourierService();

        while (true) {
            System.out.println("\n--- Courier Tracking System ---");
            System.out.println("1. Add Courier");
            System.out.println("2. Track Courier");
            System.out.println("3. Update Status");
            System.out.println("4. Display All Couriers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Tracking ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Sender Name: ");
                    String sender = sc.nextLine();
                    System.out.print("Enter Receiver Name: ");
                    String receiver = sc.nextLine();

                    Courier courier = new Courier(id, sender, receiver);
                    service.addCourier(courier);
                    break;

                case 2:
                    System.out.print("Enter Tracking ID: ");
                    service.trackCourier(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Tracking ID: ");
                    String trackId = sc.nextLine();
                    System.out.print("Enter New Status: ");
                    String status = sc.nextLine();
                    service.updateCourierStatus(trackId, status);
                    break;

                case 4:
                    service.displayAllCouriers();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}