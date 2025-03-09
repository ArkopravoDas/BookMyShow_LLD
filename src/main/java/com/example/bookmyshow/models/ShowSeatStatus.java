package com.example.bookmyshow.models;

import jakarta.persistence.ManyToOne;

public enum ShowSeatStatus {
    BOOKED,
    RESERVED,
    FREE
}
