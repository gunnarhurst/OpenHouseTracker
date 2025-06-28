package com.house.openhousetracking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDateTime checkInTime;

    private boolean hasAgent;

    public Guest() {}

    public Guest(String name, String email, String phoneNumber, boolean hasAgent) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasAgent = hasAgent;
        this.checkInTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public boolean getHasAgent() {
        return hasAgent;
    }

    public void setHasAgent(boolean hasAgent) {
        this.hasAgent = hasAgent;
    }
}
