package com.example.bookmyshow.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CreateBooking {
    List<Long> seatIds;
}
