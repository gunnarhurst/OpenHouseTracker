package com.house.openhousetracking.repository;

import com.house.openhousetracking.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
