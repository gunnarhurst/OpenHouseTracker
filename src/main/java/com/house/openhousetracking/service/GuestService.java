package com.house.openhousetracking.service;

import com.house.openhousetracking.entity.Guest;
import com.house.openhousetracking.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public Guest updateGuest(Long id, Guest updatedGuest) {
        return guestRepository.findById(id).map(existing -> {
            existing.setName(updatedGuest.getName());
            existing.setEmail(updatedGuest.getEmail());
            existing.setPhoneNumber(updatedGuest.getPhoneNumber());
            existing.setHasAgent(updatedGuest.getHasAgent());
            return guestRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Guest not found"));
    }
}
