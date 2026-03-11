import java.util.*;

// --- Helper class to manage centralized room inventory ---
class RoomInventory {
    private Map<String, Integer> inventoryMap = new HashMap<>();

    public RoomInventory() {
        // Initializing Single room count to 5
        inventoryMap.put("Single", 5);
    }

    public void updateInventory(String roomType, int count) {
        inventoryMap.put(roomType, inventoryMap.getOrDefault(roomType, 0) + count);
    }

    public int getAvailability(String roomType) {
        return inventoryMap.getOrDefault(roomType, 0);
    }
}

// --- Service class to handle logic for cancellations ---
class CancellationService {
    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds = new Stack<>();

    /** Maps reservation ID to room type. */
    private Map<String, String> reservationRoomTypeMap = new HashMap<>();

    /** Registers a confirmed booking. */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /** Cancels a confirmed booking and restores inventory safely. */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (reservationRoomTypeMap.containsKey(reservationId)) {
            String roomType = reservationRoomTypeMap.get(reservationId);

            // Restore inventory
            inventory.updateInventory(roomType, 1);

            // Add to rollback stack
            releasedRoomIds.push(reservationId);

            // Remove from active map
            reservationRoomTypeMap.remove(reservationId);

            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        }
    }

    /** Displays recently cancelled reservations. */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}

/**
 * MAIN CLASS: PalindromeCheckerApp
 * IMPORTANT: Save this file as PalindromeCheckerApp.java
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        // Initialize Objects
        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        // 1. Simulate an existing booking
        service.registerBooking("Single-1", "Single");

        // 2. Perform cancellation
        service.cancelBooking("Single-1", inventory);

        // 3. Show the history
        service.showRollbackHistory();

        // 4. Show final count
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailability("Single"));
    }
}