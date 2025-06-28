package com.house.openhousetracking.controller;

import com.house.openhousetracking.entity.Guest;
import com.house.openhousetracking.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    // Get all guests
    @GetMapping
    public List<Guest> fetchAllGuests() {
        return guestService.getAllGuests();
    }

    // Retrieve a specific guest by ID
    @GetMapping("/{id}")
    public ResponseEntity<Guest> fetchGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new guest to the system.
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest savedGuest = guestService.addGuest(guest);
        return ResponseEntity.ok(savedGuest);
    }

    // Update guest info if they already exist
    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuestInfo(@PathVariable Long id, @RequestBody Guest guest) {
        try {
            Guest updated = guestService.updateGuest(id, guest);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Remove a guest
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
